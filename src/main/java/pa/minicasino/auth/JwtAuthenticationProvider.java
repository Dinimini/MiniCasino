package pa.minicasino.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import pa.minicasino.service.PlayerDetailsService;
import pa.minicasino.util.JwtUtil;

@Component
public class JwtAuthenticationProvider {

    private final JwtUtil jwtUtil;
    private final PlayerDetailsService playerDetailsService;

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