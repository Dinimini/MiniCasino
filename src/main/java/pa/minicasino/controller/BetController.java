package pa.minicasino.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pa.minicasino.exception.InvalidBetException;
import pa.minicasino.gameLogic.BetType;
import pa.minicasino.model.BetModel;
import pa.minicasino.model.BetTypeData;
import pa.minicasino.model.PlayerModel;
import pa.minicasino.model.ResultModel;
import pa.minicasino.service.BetService;
import pa.minicasino.service.PlayerService;
import pa.minicasino.util.Util;

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

    @PostMapping("/Bet")
    public ResultModel startBet(@RequestParam int betAmount,
                                @RequestParam String betType,
                                @RequestParam int[] betParams,
                                HttpServletRequest request) {
    if (!BetType.valueOf(betType).isAcceptedValue(betParams[0])) {
        throw new InvalidBetException("Invalid bet.");
    }
    String token = Util.extractTokenFromHeader(request);
    int userbalance = playerService.getPlayerBalance(token);
    if (betAmount <= 0 || userbalance < betAmount) {
        throw new IllegalArgumentException("Invalid bet amount.");
    }
    ResultModel result = betService.placeBet(new BetModel(betType, betAmount, betParams));
    playerService.updatePlayerBalance(token, result.change());
    return result;
}
}