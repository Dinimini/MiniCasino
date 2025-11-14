package pa.minicasino.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pa.minicasino.entity.PlayerEntity;

import java.util.Collection;
import java.util.Collections;

public class PlayerDetails implements UserDetails {

    private final PlayerEntity player;

    public PlayerDetails(PlayerEntity player) {
        this.player = player;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return player.getPassword();
    }

    @Override
    public String getUsername() {
        return player.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public int getBalance() {
        return player.getBalance();
    }
}