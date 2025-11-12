package pa.minicasino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pa.minicasino.entity.PlayerEntity;
import pa.minicasino.model.PlayerDetails;
import pa.minicasino.repository.PlayerRepository;

@Service
public class PlayerDetailsService implements UserDetailsService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerDetailsService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PlayerEntity player = playerRepository.findByUsername(username);
        if (player == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new PlayerDetails(player);
    }
}