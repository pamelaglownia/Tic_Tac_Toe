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
                System.out.println("You will play with user.");
                printGameBetweenTwoUsers();
                break;
            case 2:
                System.out.println("You will play with computer.");
                break;
            case 3:
                System.out.println("You will watch game between two computers.");
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
        if (gameBoard.isWinner(playerX)) {
            System.out.println(playerX.getName() + " wins");
        } else if (gameBoard.isWinner(computerPlayer)) {
            System.out.println(computerPlayer.getName() + " wins");
        } else {
            System.out.println("Draw");
        }
    }
}