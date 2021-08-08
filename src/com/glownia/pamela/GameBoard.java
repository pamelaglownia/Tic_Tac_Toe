package com.glownia.pamela;

public class GameBoard {
    Input input = new Input();

    char[][] createInitialGameBoard() {
        System.out.println("Provide symbol to fill game board:");
        char symbol = input.takeSymbolToFillGameBoard();
        char[][] gameBoard = new char[3][3];
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = symbol;
            }
        }
        return gameBoard;
    }
}
