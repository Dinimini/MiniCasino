package pa.minicasino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pa.minicasino.entity.PlayerEntity;
import pa.minicasino.filter.JwtFilter;
import pa.minicasino.model.PlayerModel;
import pa.minicasino.repository.PlayerRepository;
import pa.minicasino.util.JwtUtil;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.playerRepository = playerRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public PlayerModel createPlayer(String username, String rawPassword) {
        if (playerRepository.findByUsername(username) != null) {
            throw new IllegalArgumentException("Player already exists with username: " + username);
        } else if (username.isEmpty() || rawPassword.isEmpty()) {
            throw new IllegalArgumentException("Username and password cannot be empty.");
        }

        PlayerEntity newPlayer = new PlayerEntity();
        newPlayer.setUsername(username);
        newPlayer.setPassword(passwordEncoder.encode(rawPassword));
        newPlayer.setBalance(1000);
        playerRepository.save(newPlayer);
        playerRepository.flush();

        return new PlayerModel(username, 1000, null);
    }

    public PlayerModel authenticatePlayer(String username, String rawPassword) {
        PlayerEntity player = findPlayerAndThrowException(username);
        System.out.println(player.getPassword());
        if (passwordEncoder.matches(rawPassword, player.getPassword()))
        {
            return new PlayerModel(username, player.getBalance(), jwtUtil.generateToken(username));
        } else {
            throw new IllegalArgumentException("Invalid username or password");
        }
    }

    public int getPlayerBalance(String token) {
        String username = extractUsernameFromToken(token);
        return findPlayerAndThrowException(username).getBalance();
    }

    public void updatePlayerBalance(String token, int change) {
        String username = extractUsernameFromToken(token);
        PlayerEntity player = findPlayerAndThrowException(username);
        player.setBalance(player.getBalance() + change);
        playerRepository.save(player);
        playerRepository.flush();
    }

    public String extractUsernameFromToken(String token) {
        return jwtUtil.extractUsername(token); // A JwtUtil-ből kiszedjük a felhasználónevet
    }



    private PlayerEntity findPlayerAndThrowException(String username) {
        PlayerEntity player = playerRepository.findByUsername(username);
        if (player == null) {
            throw new IllegalArgumentException("Player not found with username: " + username);
        }
        return player;
    }
}