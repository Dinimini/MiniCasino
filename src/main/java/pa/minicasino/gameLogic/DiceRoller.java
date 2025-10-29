package pa.minicasino.gameLogic;

public class DiceRoller {
    public int roll() {
        return (int) (Math.random() * 6) + 1;
    }
}
