package pa.minicasino.controller;



import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pa.minicasino.model.PlayerModel;
import pa.minicasino.service.PlayerService;
import pa.minicasino.util.Util;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/createPlayer")
    public PlayerModel createPlayer(@RequestBody PlayerModel playerModel) {
        return playerService.createPlayer(playerModel.username(), playerModel.password());
    }

    @GetMapping("/playerBalance")
    public int getPlayerBalance(HttpServletRequest request) {
        String token = Util.extractTokenFromHeader(request);
        return playerService.getPlayerBalance(token);
    }

    @GetMapping("/playerData")
    public PlayerModel getPlayerData(HttpServletRequest request) {
        String token = Util.extractTokenFromHeader(request);
        return new PlayerModel(playerService.extractUsernameFromToken(token), playerService.getPlayerBalance(token), null);
    }

    @PostMapping("/api/login")
    public PlayerModel login(@RequestBody PlayerModel playerModel) {
        return playerService.authenticatePlayer(playerModel.username(), playerModel.password());
    }



}