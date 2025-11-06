package pa.minicasino.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pa.minicasino.gameLogic.BetType;
import pa.minicasino.model.BetModel;
import pa.minicasino.model.BetTypeData;
import pa.minicasino.model.PlayerModel;
import pa.minicasino.model.ResultModel;
import pa.minicasino.service.BetService;
import pa.minicasino.service.PlayerService;

@RestController
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @PostMapping("/createPlayer")
    public PlayerModel createPlayer(@RequestBody String username) {
        return playerService.createPlayer(username);
    }
    @GetMapping("/playerBalance")
    public int getPlayerBalance(@RequestParam String username) {
        return playerService.getPlayerBalance(username);
    }
}
