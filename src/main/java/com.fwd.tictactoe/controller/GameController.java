package com.fwd.tictactoe.controller;

import com.fwd.tictactoe.model.GameState;
import com.fwd.tictactoe.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> createGame(@RequestParam(defaultValue = "3") int size) {
        String gameId = gameService.createGame(size);
        return ResponseEntity.ok(Map.of("gameId", gameId));
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<GameState> getGame(@PathVariable String gameId) {
        return ResponseEntity.ok(gameService.getGame(gameId));
    }

    @PostMapping("/{gameId}/move")
    public ResponseEntity<GameState> makeMove(
            @PathVariable String gameId,
            @RequestParam int row,
            @RequestParam int col) {
        return ResponseEntity.ok(gameService.makeMove(gameId, row, col));
    }
}