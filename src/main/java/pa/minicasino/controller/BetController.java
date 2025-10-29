package pa.minicasino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pa.minicasino.gameLogic.BetType;
import pa.minicasino.model.BetModel;
import pa.minicasino.model.ResultModel;
import pa.minicasino.service.BetService;
import pa.minicasino.service.PlayerService;

@RestController
public class BetController {

    private final BetService betService;
    private final PlayerService playerService;

    @Autowired
    public BetController(BetService betService, PlayerService playerService) {
        this.betService = betService;
        this.playerService = playerService;
    }

    @GetMapping("/Bet")
    public ResultModel startBet( @RequestParam int betAmount, @RequestParam String betType, @RequestParam int[] betParams) {
        if(!BetType.valueOf(betType).isAcceptedValue(betParams[0])){
            throw new IllegalArgumentException("Invalid bet.");
        }
        if(betAmount <= 0){
            throw new IllegalArgumentException("Invalid bet amount.");
        }
        ResultModel result = betService.placeBet(new BetModel(betType, betAmount, betParams));
        return result;
    }
}