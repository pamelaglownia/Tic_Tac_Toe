package com.glownia.pamela;


import java.util.Arrays;

public class Printer {
    GameBoard gameBoard = new GameBoard();

    void printWelcomeMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append("Hello! Welcome to Tic-Tac-Toe game \t(author: Pam, version 1.0)\n");
        builder.append("We have few options for you:\n");
        builder.append("- \"start\" game with other \"user\",\n");
        builder.append("- \"start\" game with computer (\"easy\" level),\n");
        builder.append("- \"exit\" game.\n");
        builder.append("Choose one from options above. To start the game type three parameters or type exit to end the game.\n");
        builder.append("(Example: to start with another user type: \"start user user\" and to start with computer type: \"start user easy)\"\n");
        builder.append("Good luck!\n");
        System.out.println(builder);
    }

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
        printWelcomeMessage();
        int userDecision = gameBoard.chooseGameOption();
        switch (userDecision) {
            case 0:
                System.out.println("Bye!");
                break;
            case 1:
                System.out.println("Let's play with other user!");
                printGameBetweenTwoUsers();
                break;
            case 2:
                System.out.println("Let's play with computer!");
                printGameWihComputer();
                break;
            case 3:
                System.out.println("Let's watch game between two computers!");
                printGameBetweenTwoComputers();
                break;
        }
    }

    void setBothUsersNames(Player firstPlayer, Player secondPlayer) {
        gameBoard.setPlayerName(firstPlayer);
        System.out.printf("First user: %s\n", firstPlayer.getName());
        if (firstPlayer.getName() == 'X') {
            secondPlayer.setName('O');
        } else {
            secondPlayer.setName('X');
        }
        System.out.printf("Second user: %s\n", secondPlayer.getName());
    }

    void printGameBetweenTwoUsers() {
        Player firstPlayer = new Player();
        Player secondPlayer = new Player();
        setBothUsersNames(firstPlayer, secondPlayer);
        char turn = '_';
        char[][] currentGameBoard = gameBoard.createEmptyGameBoard();
        int emptyCells = gameBoard.countEmptyCells();
        while (emptyCells > 0) {
            printGameBoard(currentGameBoard);
            if (turn == firstPlayer.getName()) {
                turn = gameBoard.movePlayer(secondPlayer);
                if (gameBoard.isWinner(secondPlayer)) {
                    break;
                }
            } else {
                turn = gameBoard.movePlayer(firstPlayer);
                if (gameBoard.isWinner(firstPlayer)) {
                    break;
                }
            }
            emptyCells--;
        }
        printGameBoard(currentGameBoard);
        printWinner(firstPlayer, secondPlayer);
    }


    void printGameWihComputer() {
        char turn = '_';
        char[][] currentGameBoard = gameBoard.createEmptyGameBoard();
        int emptyCells = gameBoard.countEmptyCells();
        Player playerX = new Player();
        playerX.setName('X');
        Player computerPlayer = new Player();
        computerPlayer.setName('O');
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
        printWinner(playerX, computerPlayer);
    }

    void printGameBetweenTwoComputers() {
        char turn = '_';
        char[][] currentGameBoard = gameBoard.createEmptyGameBoard();
        int emptyCells = gameBoard.countEmptyCells();
        Player firstComputer = new Player();
        firstComputer.setName('X');
        Player secondComputer = new Player();
        secondComputer.setName('O');
        while (emptyCells > 0) {
            printGameBoard(currentGameBoard);
            if (turn == 'X') {
                System.out.println("Second computer is making move level \"easy\"");
                turn = gameBoard.moveComputer(secondComputer);
                if (gameBoard.isWinner(secondComputer)) {
                    break;
                }
            } else {
                System.out.println("First computer is making move level \"easy\"");
                turn = gameBoard.moveComputer(firstComputer);
                if (gameBoard.isWinner(firstComputer)) {
                    break;
                }
            }
            emptyCells--;
        }
        printGameBoard(currentGameBoard);
        printWinner(firstComputer, secondComputer);
    }

    void printWinner(Player firstPlayer, Player secondPlayer) {
        if (gameBoard.isWinner(firstPlayer)) {
            System.out.println(firstPlayer.getName() + " wins");
        } else if (gameBoard.isWinner(secondPlayer)) {
            System.out.println(secondPlayer.getName() + " wins");
        } else {
            System.out.println("Draw");
        }
    }
}