package com.fwd.tictactoe.model;

public class GameState {
    private final Board board;
    private String currentPlayer;
    private boolean gameOver;
    private String winner;

    public GameState(int size) {
        this.board = new Board(size);
        this.currentPlayer = "X";
        this.gameOver = false;
    }

    public Board getBoard() {
        return board;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String getWinner() {
        return winner;
    }

    public void switchPlayer() {
        this.currentPlayer = "X".equals(currentPlayer) ? "O" : "X";
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}