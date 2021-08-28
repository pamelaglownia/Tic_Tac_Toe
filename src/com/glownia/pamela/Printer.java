package com.glownia.pamela;

class Printer {
//    GameBoard gameBoard = new GameBoard();

    void printWelcomeMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append("Hello! Welcome to Tic-Tac-Toe game \t(author: Pam, version 1.0)\n");
        builder.append("I have few options for you:\n");
        builder.append("- \"start\" game with other \"user\",\n");
        builder.append("- \"start\" game with computer (\"easy\" or \"medium\" level),\n");
        builder.append("- \"start\" watching game between two computers (\"easy\" or \"medium\" level),\n");
        builder.append("- \"exit\" game.\n");
        builder.append("Choose one from the options above. To start the game type three parameters or type exit to end the game.\n");
        builder.append("(Explanation:\n*to start with another user type: \"start user user\",\n");
        builder.append("*to start with computer on easy level type: \"start user easy\" or on the medium level: \"start user medium\",\n");
        builder.append("*to watch game between two computers type: \"start easy easy\" or \"start medium medium\"\n");
        builder.append("Good luck!\n");
        System.out.println(builder);
    }

    void printGameBoard(char[][] currentGameBoard) {
        System.out.println("---------");
        for (int i = 0; i < currentGameBoard.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < currentGameBoard[i].length; j++) {
                System.out.print(currentGameBoard[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    void sayGoodBye() {
        System.out.println("Bye!");
    }

    void inviteToPlayWithUser() {
        System.out.println("Let's play with other user!");
    }

    void inviteToPlayWithComputer(String option) {
        System.out.printf("Let's play with computer (%s level)!\n", option.toLowerCase());
    }

    void inviteToWatchGameBetweenComputers() {
        System.out.println("Let's watch game between two computers!");
    }

    //    void printGameWihComputer(MenuOption computerLevel) {
//        char turn = '_';
//        char[][] currentGameBoard = gameBoard.createEmptyGameBoard();
//        int emptyCells = gameBoard.countEmptyCells();
//        Player playerX = new Player();
//        playerX.setName('X');
//        Computer computerPlayer = new Computer('O');
//        while (emptyCells > 0) {
//            printGameBoard(currentGameBoard);
//            if (turn == 'X') {
//                if (computerLevel == MenuOption.EASY) {
//                    System.out.println("Making move level \"easy\"");
//                    turn = computerPlayer.easyMove(currentGameBoard, gameBoard);
//                } else {
//                    System.out.println("Making move level \"medium\"");
//                    turn = computerPlayer.mediumMove(currentGameBoard, gameBoard);
//                }
//                if (computerPlayer.isWinner(currentGameBoard)) {
//                    break;
//                }
//            } else {
//                turn = playerX.move(gameBoard, currentGameBoard);
//                if (playerX.isWinner(currentGameBoard)) {
//                    break;
//                }
//            }
//            emptyCells--;
//        }
//        printGameBoard(currentGameBoard);
//        printWinner(playerX, computerPlayer, currentGameBoard);
//    }
//
//    void printGameBetweenTwoComputers() throws InterruptedException {
//        char turn = '_';
//        char[][] currentGameBoard = gameBoard.createEmptyGameBoard();
//        int emptyCells = gameBoard.countEmptyCells();
//        Computer firstComputer = new Computer('X');
//        Computer secondComputer = new Computer('O');
//        while (emptyCells > 0) {
//            printGameBoard(currentGameBoard);
//            if (turn == 'X') {
//                Thread.sleep(1000);
//                System.out.println("Second computer is making move");
//                turn = secondComputer.easyMove(currentGameBoard, gameBoard);
//                if (secondComputer.isWinner(currentGameBoard)) {
//                    break;
//                }
//            } else {
//                Thread.sleep(1000);
//                System.out.println("First computer is making move");
//                turn = firstComputer.easyMove(currentGameBoard, gameBoard);
//                if (firstComputer.isWinner(currentGameBoard)) {
//                    break;
//                }
//            }
//            emptyCells--;
//        }
//        printGameBoard(currentGameBoard);
//        printWinner(firstComputer, secondComputer, currentGameBoard);
//    }
//
    void printWinner(char name) {
        System.out.println(name + " wins");
    }

    void printDraw() {
        System.out.println("Draw");
    }
}