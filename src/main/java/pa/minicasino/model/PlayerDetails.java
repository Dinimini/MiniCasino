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
        // Egyszerű példa, ahol minden felhasználó "USER" szerepkört kap
        return Collections.emptyList(); // Vagy használhatsz szerepköröket is, pl. "ROLE_USER"
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
        return true; // További logika implementálható, ha szükséges
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
        return player.getBalance(); // Ha például a balance mezőt is elérhetővé akarod tenni
    }
}