package pa.minicasino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pa.minicasino.gameLogic.BetType;
import pa.minicasino.gameLogic.DiceRoller;
import pa.minicasino.model.BetModel;
import pa.minicasino.model.ResultModel;
@Service
public class BetService {

    private DiceRoller diceRoller;

    @Autowired
    public BetService(DiceRoller diceRoller) {
        this.diceRoller = diceRoller;
    }

    public ResultModel placeBet(BetModel betModel) {
        boolean isWin = BetType.valueOf(betModel.betType()).isWin( diceRoller.roll(), betModel.betParams()[0]);
        int change = isWin ? (int) (betModel.betAmount() * BetType.valueOf(betModel.betType()).expectedValue(betModel.betParams()[0])) : -betModel.betAmount();
        return new ResultModel(diceRoller.roll(), change, isWin);
    }

}
