package com.fwd.tictactoe.model;

public class Board {
    private final int size;
    private int count = 0;
    private final String[][] grid;

    public Board(int size) {
        this.size = size;
        this.count = count;
        this.grid = new String[size][size];
    }

    public int getSize() {
        return size;
    }
    public int getCount() {
        return count;
    }
    public String[][] getGrid() {
        return grid;
    }

    public boolean placeMove(int row, int col, String player) {
        if (row < 0 || row >= size || col < 0 || col >= size || grid[row][col] != null) {
            return false;
        }
        grid[row][col] = player;
        count++;
        return true;
    }

    public boolean checkWin(String player, int row, int col) {
        boolean winRow = true;
        boolean winCol = true;
        boolean winDiag1 = true;
        boolean winDiag2 = true;

        // Check the affected row and column
        for (int i = 0; i < size; i++) {
            if (!player.equals(grid[row][i])) { //check for the horizontal value
                winRow = false;
            }
            if (!player.equals(grid[i][col])) { //check for the vertical value
                winCol = false;
            }
        }

        // Check main diagonal (\) only if (row == col)
        if (row != col) winDiag1 = false; //for the row,col --> 0,0 ; 1,1 ; 2;2
        if (winDiag1) {
            for (int i = 0; i < size; i++) {
                if (!player.equals(grid[i][i])) {
                    winDiag1 = false;
                    break;
                }
            }
        }

        // Check anti-diagonal (/) only if (row + col == size - 1)
        if (row + col != size - 1) winDiag2 = false; //for the row,col --> 0+2 != 3-1, 1+1 != 3-1, 2+0
        if (winDiag2) {
            for (int i = 0; i < size; i++) {
                if (!player.equals(grid[i][size - 1 - i])) {
                    winDiag2 = false;
                    break;
                }
            }
        }

        return winRow || winCol || winDiag1 || winDiag2;
    }

    public boolean isFull() {
        return count == size * size;
    }
}