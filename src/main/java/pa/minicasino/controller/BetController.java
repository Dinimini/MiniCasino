package pa.minicasino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pa.minicasino.gameLogic.BetType;
import pa.minicasino.model.BetModel;
import pa.minicasino.model.BetTypeData;
import pa.minicasino.model.ResultModel;
import pa.minicasino.service.BetService;
import pa.minicasino.service.PlayerService;

@RestController
public class BetController {

    private final BetService betService;
    private final PlayerService playerService;
    private final PlayerController playerController;

    @Autowired
    public BetController(BetService betService, PlayerService playerService, PlayerController playerController) {
        this.betService = betService;
        this.playerService = playerService;
        this.playerController = playerController;
    }

    @GetMapping("/allBets")
    public BetTypeData[] getAllBets(){
        BetTypeData[] betTypes = new BetTypeData[BetType.values().length];
        for(int i = 0; i < BetType.values().length; i++){
            betTypes[i] = BetType.values()[i].getBetType();
        }
        return betTypes;
    }

    @GetMapping("/Bet")
    public ResultModel startBet( @RequestParam int betAmount, @RequestParam String betType, @RequestParam int[] betParams) {
        if(!BetType.valueOf(betType).isAcceptedValue(betParams[0])){
            throw new IllegalArgumentException("Invalid bet.");
        }
        if(betAmount <= 0||playerService.getPlayerBalance("user") < betAmount){
            throw new IllegalArgumentException("Invalid bet amount.");
        }
        ResultModel result = betService.placeBet(new BetModel(betType, betAmount, betParams));
        playerService.updatePlayerBalance("user", result.change());
        return result;
    }
}