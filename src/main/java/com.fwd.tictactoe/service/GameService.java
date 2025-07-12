package com.fwd.tictactoe.service;

import com.fwd.tictactoe.exception.GameException;
import com.fwd.tictactoe.model.GameState;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GameService {

    private final ConcurrentHashMap<String, GameState> games = new ConcurrentHashMap<>();

    public String createGame(int size) {
        if (size < 3) throw new GameException("Minimum game size is 3");
        String gameId = UUID.randomUUID().toString();
        games.put(gameId, new GameState(size));
        return gameId;
    }

    public GameState getGame(String gameId) {
        GameState state = games.get(gameId);
        if (state == null) throw new GameException("Game not found");
        return state;
    }

    public GameState makeMove(String gameId, int row, int col) {
        GameState state = getGame(gameId);
        if (state.isGameOver()) throw new GameException("Game is already over");

        boolean valid = state.getBoard().placeMove(row, col, state.getCurrentPlayer());
        if (!valid) throw new GameException("Invalid move");

        if (state.getBoard().checkWin(state.getCurrentPlayer(), row, col)) {
            state.setGameOver(true);
            state.setWinner(state.getCurrentPlayer());
        } else if (state.getBoard().isFull()) {
            state.setGameOver(true);
        } else {
            state.switchPlayer();
        }

        return state;
    }
}
