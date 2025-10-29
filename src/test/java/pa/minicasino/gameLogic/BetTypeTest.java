package pa.minicasino.gameLogic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BetTypeTest {

    @Test
    void getName() {
    }

    @Test
    void getBetType() {
    }

    @Test
    void expectedValue() {
        assertEquals(2, BetType.ISODD.expectedValue(1));
    }

    @Test
    void isWin() {
        assertEquals(true, BetType.GREATER_THAN.isWin(1, 2));
    }
}