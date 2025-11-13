package pa.minicasino.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PlayerServiceTest {

    @Mock
    private PlayerService playerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createPlayer() {
    }

    @Test
    void getPlayerByUsername() {
    }

    @Test
    void updatePlayerBalance() {
    }

    @Test
    void getPlayerBalance() {
        String username = "testUser";
        int expectedBalance = 1000;

        when(playerService.getPlayerBalance(username)).thenReturn(expectedBalance);

        int actualBalance = playerService.getPlayerBalance(username);

        assertEquals(expectedBalance, actualBalance);
    }
}