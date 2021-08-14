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
        char[][] currentGameBoard = gameBoard.createEmptyGameBoard();
        int emptyCells = gameBoard.countEmptyCells();
        Player playerX = new Player('X');
        Player playerO = new Player('O');
        while (emptyCells > 0) {
            printGameBoard(currentGameBoard);
            if (turn == 'X') {
                turn = gameBoard.move(playerO);
                if (gameBoard.isWinner(playerO)) {
                    break;
                }
            } else {
                turn = gameBoard.move(playerX);
                if (gameBoard.isWinner(playerX)) {
                    break;
                }
            }
            emptyCells--;
        }
        printGameBoard(currentGameBoard);
        if (gameBoard.isWinner(playerX)) {
            System.out.println(playerX.getName() + " wins");
        } else if (gameBoard.isWinner(playerO)) {
            System.out.println(playerO.getName() + " wins");
        } else {
            System.out.println("Draw");
        }
    }
}