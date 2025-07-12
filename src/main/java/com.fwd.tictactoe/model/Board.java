package com.fwd.tictactoe.model;

public class Board {
    private final int size;
    private final String[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new String[size][size];
    }

    public int getSize() {
        return size;
    }

    public String[][] getGrid() {
        return grid;
    }

    public boolean placeMove(int row, int col, String player) {
        if (row < 0 || row >= size || col < 0 || col >= size || grid[row][col] != null) {
            return false;
        }
        grid[row][col] = player;
        return true;
    }

    public boolean checkWin(String player) {
        // Check rows & columns
        for (int i = 0; i < size; i++) {
            boolean rowWin = true;
            boolean colWin = true;
            for (int j = 0; j < size; j++) {
                if (!player.equals(grid[i][j])) rowWin = false;
                if (!player.equals(grid[j][i])) colWin = false;
            }
            if (rowWin || colWin) return true;
        }

        // Check diagonals
        boolean diag1 = true, diag2 = true;
        for (int i = 0; i < size; i++) {
            if (!player.equals(grid[i][i])) diag1 = false;
            if (!player.equals(grid[i][size - i - 1])) diag2 = false;
        }

        return diag1 || diag2;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == null) return false;
            }
        }
        return true;
    }
}