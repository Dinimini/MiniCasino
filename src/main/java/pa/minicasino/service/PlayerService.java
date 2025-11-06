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

    public PlayerModel createPlayer(String username) {
        PlayerEntity newPlayer = new PlayerEntity();
        newPlayer.setUsername(username);
        newPlayer.setBalance(1000);
        playerRepository.save(newPlayer);
        return new PlayerModel(username, 1000);
    }

    public PlayerModel getPlayerByUsername(String username) {
        PlayerEntity player = playerRepository.findByUsername(username);
        if (player == null) {
            throw new IllegalArgumentException("Player not found with username: " + username);
        }
        return new PlayerModel(player.getUsername(), player.getBalance());
    }

    public void updatePlayerBalance(String username, int balanceChange) {
        PlayerEntity player = playerRepository.findByUsername(username);
        if (player == null) {
            throw new IllegalArgumentException("Player not found with username: " + username);
        }

        player.changeBalance(balanceChange);

        playerRepository.save(player);
    }

    public int getPlayerBalance(String username){
        PlayerEntity player = playerRepository.findByUsername(username);
        if (player == null) {
            throw new IllegalArgumentException("Player not found with username: " + username);
        }
        return player.getBalance();
    }


}