package com.glownia.pamela;

public class GameBoard {
    Input input = new Input();

    char[][] createInitialGameBoard() {
        String fillingInitialCells = input.inputInitialCells();
        int counter = 0;
        char[][] gameBoard = new char[3][3];
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = fillingInitialCells.charAt(counter);
                counter++;
            }
        }
        return gameBoard;
    }
}
