package pa.minicasino.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pa.minicasino.gameLogic.DiceRoller;
import pa.minicasino.model.BetModel;
import pa.minicasino.model.ResultModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BetServiceTest {

    @Test
    void placeBet() {
        // Arrange: Mock the DiceRoller
        DiceRoller mockDiceRoller = Mockito.mock(DiceRoller.class);
        when(mockDiceRoller.roll()).thenReturn(4); // Always return 4

        // Create the BetService with the mocked DiceRoller
        BetService betService = new BetService(mockDiceRoller);

        // Prepare a BetModel for the test
        BetModel betModel = new BetModel("GREATER_THAN", 100, new int[]{1});

        // Act: Call the placeBet() method
        ResultModel result = betService.placeBet(betModel);

        // Assert: Verify the result
        assertEquals(4, result.roll()); // diceRoller.roll() should return 4
        assertEquals(true, result.isWin());  // Assuming "ROLL_OVER" and betParams[0] = 3 result in a win
        assertEquals(500, result.change()); // Expected balance change when bet is successful
    }
}