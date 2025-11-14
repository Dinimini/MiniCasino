package pa.minicasino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pa.minicasino.entity.PlayerEntity;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
    PlayerEntity findByUsername(String username);
}