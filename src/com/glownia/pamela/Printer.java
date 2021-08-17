package com.glownia.pamela;

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
        firstPlayer.setPlayerName();
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
                turn = secondPlayer.move(gameBoard, currentGameBoard);
                if (secondPlayer.isWinner(currentGameBoard)) {
                    break;
                }
            } else {
                turn = firstPlayer.move(gameBoard, currentGameBoard);
                if (firstPlayer.isWinner(currentGameBoard)) {
                    break;
                }
            }
            emptyCells--;
        }
        printGameBoard(currentGameBoard);
        printWinner(firstPlayer, secondPlayer, currentGameBoard);
    }

    void printGameWihComputer() {
        char turn = '_';
        char[][] currentGameBoard = gameBoard.createEmptyGameBoard();
        int emptyCells = gameBoard.countEmptyCells();
        Player playerX = new Player();
        playerX.setName('X');
        Computer computerPlayer = new Computer('O');
        while (emptyCells > 0) {
            printGameBoard(currentGameBoard);
            if (turn == 'X') {
                System.out.println("Making move level \"easy\"");
                turn = computerPlayer.move(currentGameBoard, gameBoard);
                if (computerPlayer.isWinner(currentGameBoard)) {
                    break;
                }
            } else {
                turn = playerX.move(gameBoard, currentGameBoard);
                if (playerX.isWinner(currentGameBoard)) {
                    break;
                }
            }
            emptyCells--;
        }
        printGameBoard(currentGameBoard);
        printWinner(playerX, computerPlayer, currentGameBoard);
    }

    void printGameBetweenTwoComputers() {
        char turn = '_';
        char[][] currentGameBoard = gameBoard.createEmptyGameBoard();
        int emptyCells = gameBoard.countEmptyCells();
        Computer firstComputer = new Computer('X');
        Computer secondComputer = new Computer('O');
        while (emptyCells > 0) {
            printGameBoard(currentGameBoard);
            if (turn == 'X') {
                System.out.println("Second computer is making move level \"easy\"");
                turn = secondComputer.move(currentGameBoard, gameBoard);
                if (secondComputer.isWinner(currentGameBoard)) {
                    break;
                }
            } else {
                System.out.println("First computer is making move level \"easy\"");
                turn = firstComputer.move(currentGameBoard, gameBoard);
                if (firstComputer.isWinner(currentGameBoard)) {
                    break;
                }
            }
            emptyCells--;
        }
        printGameBoard(currentGameBoard);
        printWinner(firstComputer, secondComputer, currentGameBoard);
    }

    void printWinner(Player firstPlayer, Player secondPlayer, char[][] currentGameBoard) {
        if (firstPlayer.isWinner(currentGameBoard)) {
            System.out.println(firstPlayer.getName() + " wins");
        } else if (secondPlayer.isWinner(currentGameBoard)) {
            System.out.println(secondPlayer.getName() + " wins");
        } else {
            System.out.println("Draw");
        }
    }

    void printWinner(Player firstPlayer, Computer computer, char[][] currentGameBoard) {
        if (firstPlayer.isWinner(currentGameBoard)) {
            System.out.println(firstPlayer.getName() + " wins");
        } else if (computer.isWinner(currentGameBoard)) {
            System.out.println(computer.getName() + " wins");
        } else {
            System.out.println("Draw");
        }
    }

    void printWinner(Computer firstComputer, Computer secondComputer, char[][] currentGameBoard) {
        if (firstComputer.isWinner(currentGameBoard)) {
            System.out.println(firstComputer.getName() + " wins");
        } else if (secondComputer.isWinner(currentGameBoard)) {
            System.out.println(secondComputer.getName() + " wins");
        } else {
            System.out.println("Draw");
        }
    }
}