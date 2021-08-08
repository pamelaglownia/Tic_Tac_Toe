package com.glownia.pamela;

import java.util.Arrays;

public class Printer {

    void printInitialGameBoard() {
        GameBoard gameBoard = new GameBoard();
        char[][] initialGameBoard = gameBoard.createInitialGameBoard();
        for (int i = 0; i < initialGameBoard.length; i++) {
            System.out.println(Arrays.toString(initialGameBoard[i]));
        }
    }
}
