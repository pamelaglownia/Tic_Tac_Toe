package com.glownia.pamela;

class GameBoard {
    private final char[][] gameBoard;

    GameBoard() {
        this.gameBoard = new char[3][3];
    }

    char[][] createEmptyGameBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = ' ';
            }
        }
        return gameBoard;
    }

    boolean isEmptyCell(int i, int j) {
        return gameBoard[i - 1][j - 1] == '_' || gameBoard[i - 1][j - 1] == ' ';
    }

    int countEmptyCells() {
        int emptyCells = 0;
        for (char[] chars : gameBoard) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '_' || chars[j] == ' ') {
                    emptyCells += 1;
                }
            }
        }
        return emptyCells;
    }
}