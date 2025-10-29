package pa.minicasino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pa.minicasino.entity.PlayerEntity;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
    PlayerEntity findByUsername(String username);
}