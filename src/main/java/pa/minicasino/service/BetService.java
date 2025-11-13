package pa.minicasino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pa.minicasino.gameLogic.BetType;
import pa.minicasino.gameLogic.DiceRoller;
import pa.minicasino.model.BetModel;
import pa.minicasino.model.ResultModel;
@Service
public class BetService {

    private final DiceRoller diceRoller;

    @Autowired
    public BetService(DiceRoller diceRoller) {
        this.diceRoller = diceRoller;
    }

    public ResultModel placeBet(BetModel betModel) {
        BetType bet = BetType.valueOf(betModel.betType());
        boolean isWin = bet.isWin( diceRoller.roll(), betModel.betParams()[0]);
        int change = isWin ? (int) (betModel.betAmount() * bet.expectedValue(betModel.betParams()[0])) : -betModel.betAmount();
        return new ResultModel(diceRoller.roll(), change, isWin);
    }

}
