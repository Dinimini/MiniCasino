package pa.minicasino.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pa.minicasino.controller.PlayerController;
import pa.minicasino.gameLogic.DiceRoller;
import pa.minicasino.repository.PlayerRepository;
import pa.minicasino.service.BetService;
import pa.minicasino.service.PlayerService;

@Configuration
public class Config {

    @Bean public DiceRoller diceRoller() {
        return new DiceRoller();
    }

    @Bean
    public BetService betService() {
        return new BetService(diceRoller());
    }



    @Bean
    public PlayerController playerController() {
        return new PlayerController();
    }

}
