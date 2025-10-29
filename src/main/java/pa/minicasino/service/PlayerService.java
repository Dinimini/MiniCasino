package pa.minicasino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pa.minicasino.entity.PlayerEntity;
import pa.minicasino.model.PlayerModel;
import pa.minicasino.repository.PlayerRepository;

import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /**
     * Fetch a PlayerModel by username.
     *
     * @param username The player's username.
     * @return PlayerModel containing the player's username and balance.
     */
    public PlayerModel getPlayerByUsername(String username) {
        PlayerEntity player = playerRepository.findByUsername(username);
        if (player == null) {
            throw new IllegalArgumentException("Player not found with username: " + username);
        }
        return new PlayerModel(player.getUsername(), player.getBalance());
    }

    /**
     * Update the balance for a player.
     *
     * @param username The player's username.
     * @param balanceChange The amount to change the balance (e.g., positive for credit, negative for debit).
     */
    public void updatePlayerBalance(String username, int balanceChange) {
        PlayerEntity player = playerRepository.findByUsername(username);
        if (player == null) {
            throw new IllegalArgumentException("Player not found with username: " + username);
        }

        // Update the player's balance
        player.changeBalance(balanceChange);

        // Save the updated entity
        playerRepository.save(player);
    }
}