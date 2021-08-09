package com.glownia.pamela;

public class Printer {

    void printInitialGameBoard() {
        GameBoard gameBoard = new GameBoard();
        char[][] initialGameBoard = gameBoard.createInitialGameBoard();
        System.out.println("---------");
        for (int i = 0; i < initialGameBoard.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < initialGameBoard[i].length; j++) {
                if (initialGameBoard[i][j] == '_') {
                    initialGameBoard[i][j] = ' ';
                }
                System.out.print(initialGameBoard[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }
}
