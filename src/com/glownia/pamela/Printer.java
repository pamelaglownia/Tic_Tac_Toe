package com.glownia.pamela;

public class Printer {
    GameBoard gameBoard = new GameBoard();

    void printGameBoard(char[][] initialGameBoard) {
        System.out.println("---------");
        for (int i = 0; i < initialGameBoard.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < initialGameBoard[i].length; j++) {
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
        Player computerPlayer = new Player('O');
        while (emptyCells > 0) {
            printGameBoard(currentGameBoard);
            if (turn == 'X') {
                System.out.println("Making move level \"easy\"");
                turn = gameBoard.moveComputer(computerPlayer);
                if (gameBoard.isWinner(computerPlayer)) {
                    break;
                }
            } else {
                turn = gameBoard.movePlayer(playerX);
                if (gameBoard.isWinner(playerX)) {
                    break;
                }
            }
            emptyCells--;
        }
        printGameBoard(currentGameBoard);
        if (gameBoard.isWinner(playerX)) {
            System.out.println(playerX.getName() + " wins");
        } else if (gameBoard.isWinner(computerPlayer)) {
            System.out.println(computerPlayer.getName() + " wins");
        } else {
            System.out.println("Draw");
        }
    }
}