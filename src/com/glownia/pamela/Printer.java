package com.glownia.pamela;

public class Printer {
    GameBoard gameBoard = new GameBoard();

    void printGameBoard(char[][] initialGameBoard) {
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

    void printGame() {
        char turn = '_';
        char[][] currentGameBoard = gameBoard.createInitialGameBoard();
        int emptyCells = gameBoard.countEmptyCells();
        Player playerX = new Player('X');
        Player playerO = new Player('O');
        do {
            printGameBoard(currentGameBoard);
            if (turn == 'X') {
                turn = gameBoard.move(playerO);
            } else {
                turn = gameBoard.move(playerX);
            }
            emptyCells--;
        } while (emptyCells > 0);
        System.out.println("End");
    }
}