package pa.minicasino.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pa.minicasino.service.PlayerDetailsService;
import pa.minicasino.service.PlayerService;
import pa.minicasino.util.JwtUtil;

@Component
public class JwtAuthenticationProvider {

    private JwtUtil jwtUtil;
    private PlayerDetailsService playerDetailsService;

    @Autowired
    public JwtAuthenticationProvider(JwtUtil jwtUtil, PlayerDetailsService playerDetailsService) {
        this.jwtUtil = jwtUtil;
        this.playerDetailsService = playerDetailsService;
    }

    public UserDetails getUserDetailsFromToken(String token) {
        String username = jwtUtil.extractUsername(token);
        return (username != null) ? playerDetailsService.loadUserByUsername(username) : null;
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return jwtUtil.validateToken(token, userDetails.getUsername());
    }




}