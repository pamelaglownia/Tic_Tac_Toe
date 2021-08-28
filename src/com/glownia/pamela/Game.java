package com.glownia.pamela;

import java.util.Random;

class Game {
    private final GameBoard gameBoard = new GameBoard();
    private final Printer printer = new Printer();
    private final Input input = new Input();

    private int chooseGameOption() {
        String[] setOfUserChoice = input.inputCommand();
        return MenuOption.chooseOption(setOfUserChoice);
    }

    private char setPlayerName() {
        return input.chooseCharacterToPlay();
    }

    private void setBothUsersNames(Player firstPlayer, Player secondPlayer) {
        firstPlayer.setName(setPlayerName());
        if (firstPlayer.getName() == 'X') {
            secondPlayer.setName('O');
        } else {
            secondPlayer.setName('X');
        }
    }

    private int[] takeCoordinates() {
        int[] coordinates = input.inputCoordinates();
        int i = coordinates[0];
        int j = coordinates[1];
        while (!(gameBoard.isEmptyCell(i, j))) {
            System.out.println("This cell is occupied! Choose another one!");
            coordinates = input.inputCoordinates();
            i = coordinates[0];
            j = coordinates[1];
        }
        return coordinates;
    }

    private char playerMove(char[][] currentGameBoard, char name) {
        int[] correctCoordinates = takeCoordinates();
        int i = correctCoordinates[0] - 1;
        int j = correctCoordinates[1] - 1;
        currentGameBoard[i][j] = Character.toUpperCase(name);
        return currentGameBoard[i][j];
    }

    private int[] takeRandomCoordinatesForComputerPlayer(GameBoard gameBoard) {
        int[] coordinates = new int[2];
        Random random = new Random();
        coordinates[0] = random.nextInt(3) + 1;
        coordinates[1] = random.nextInt(3) + 1;
        while (!(gameBoard.isEmptyCell(coordinates[0], coordinates[1]))) {
            coordinates[0] = random.nextInt(3) + 1;
            coordinates[1] = random.nextInt(3) + 1;
        }
        return coordinates;
    }

    private char easyComputerMove(char[][] currentGameBoard, char name) {
        int[] correctCoordinates = takeRandomCoordinatesForComputerPlayer(gameBoard);
        int i = correctCoordinates[0] - 1;
        int j = correctCoordinates[1] - 1;
        currentGameBoard[i][j] = Character.toUpperCase(name);
        return currentGameBoard[i][j];
    }

    private char mediumComputerMove(char[][] currentGameBoard, char playerName, char computerName) {
        int bestI = 0;
        int bestJ = 0;
        boolean isBest = false;
        int emptyCells = gameBoard.countEmptyCells();
        for (int i = 0; i < currentGameBoard.length; i++) {
            for (int j = 0; j < currentGameBoard[i].length; j++) {
                if (currentGameBoard[i][j] == ' ') {
                    currentGameBoard[i][j] = playerName;
                    if (emptyCells >= 8 || isWinner(currentGameBoard, playerName)) {
                        bestI = i;
                        bestJ = j;
                        isBest = true;
                    }
                    currentGameBoard[i][j] = ' ';
                }
            }
        }

        if (currentGameBoard[bestI][bestJ] == ' ' && isBest) {
            currentGameBoard[bestI][bestJ] = Character.toUpperCase(computerName);
            return currentGameBoard[bestI][bestJ];
        } else {
            return easyComputerMove(currentGameBoard, computerName);
        }
    }

    void playGame() throws InterruptedException {
        printer.printWelcomeMessage();
        int userDecision = chooseGameOption();
        switch (userDecision) {
            case 0:
                printer.sayGoodBye();
                break;
            case 1:
                printer.inviteToPlayWithUser();
                playGameBetweenTwoUsers();
                break;
            case 2:
                printer.inviteToPlayWithComputer(MenuOption.EASY.name());
                playGameWithComputer(MenuOption.EASY);
                break;
            case 3:
                printer.inviteToPlayWithComputer(MenuOption.MEDIUM.name());
                playGameWithComputer(MenuOption.MEDIUM);
                break;
            case 4:
                printer.inviteToWatchGameBetweenComputers();
                playGameBetweenTwoComputers();
                break;
        }
    }

    private void playGameBetweenTwoUsers() {
        Player firstPlayer = new Player();
        Player secondPlayer = new Player();
        setBothUsersNames(firstPlayer, secondPlayer);
        char turn = '_';
        char[][] currentGameBoard = gameBoard.createEmptyGameBoard();
        int emptyCells = gameBoard.countEmptyCells();
        while (emptyCells > 0) {
            printer.printGameBoard(currentGameBoard);
            if (turn == firstPlayer.getName()) {
                turn = playerMove(currentGameBoard, secondPlayer.getName());
                if (isWinner(currentGameBoard, secondPlayer.getName())) {
                    break;
                }
            } else {
                turn = playerMove(currentGameBoard, firstPlayer.getName());
                if (isWinner(currentGameBoard, firstPlayer.getName())) {
                    break;
                }
            }
            emptyCells--;
        }
        printer.printGameBoard(currentGameBoard);
        checkWinner(turn, emptyCells, currentGameBoard);
    }

    private void playGameWithComputer(MenuOption computerLevel) {
        char turn = '_';
        char[][] currentGameBoard = gameBoard.createEmptyGameBoard();
        int emptyCells = gameBoard.countEmptyCells();
        Player playerX = new Player();
        playerX.setName('X');
        Computer computerPlayer = new Computer('O');
        while (emptyCells > 0) {
            printer.printGameBoard(currentGameBoard);
            if (turn == 'X') {
                if (computerLevel == MenuOption.EASY) {
                    System.out.println("Making move level \"easy\"");
                    turn = easyComputerMove(currentGameBoard, computerPlayer.getName());
                } else {
                    System.out.println("Making move level \"medium\"");
                    turn = mediumComputerMove(currentGameBoard, playerX.getName(), computerPlayer.getName());
                }
                if (isWinner(currentGameBoard, computerPlayer.getName())) {
                    break;
                }
            } else {
                turn = playerMove(currentGameBoard, playerX.getName());
                if (isWinner(currentGameBoard, playerX.getName())) {
                    break;
                }
            }
            emptyCells--;
        }
        printer.printGameBoard(currentGameBoard);
        checkWinner(turn, emptyCells, currentGameBoard);
    }

    private void playGameBetweenTwoComputers() throws InterruptedException {
        char turn = '_';
        char[][] currentGameBoard = gameBoard.createEmptyGameBoard();
        int emptyCells = gameBoard.countEmptyCells();
        Computer firstComputer = new Computer('X');
        Computer secondComputer = new Computer('O');
        while (emptyCells > 0) {
            printer.printGameBoard(currentGameBoard);
            if (turn == 'X') {
                Thread.sleep(1000);
                System.out.println("Second computer is making move");
                turn = easyComputerMove(currentGameBoard, secondComputer.getName());
                if (isWinner(currentGameBoard, secondComputer.getName())) {
                    break;
                }
            } else {
                Thread.sleep(1000);
                System.out.println("First computer is making move");
                turn = easyComputerMove(currentGameBoard, firstComputer.getName());
                if (isWinner(currentGameBoard, firstComputer.getName())) {
                    break;
                }
            }
            emptyCells--;
        }
        printer.printGameBoard(currentGameBoard);
        checkWinner(turn, emptyCells, currentGameBoard);
    }

    private boolean isWinner(char[][] gameBoard, char name) {
        //columns
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[i][0] == name)) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[i][1] == name)) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[i][2] == name)) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }

        //rows
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[0][i] == name)) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[1][i] == name)) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[2][i] == name)) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }

        //diagonal
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[i][i] == name)) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }

        //anti-diagonal
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[i][gameBoard.length - 1 - i] == name)) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }
        return false;
    }

    private void checkWinner(char name, int emptyCells, char[][] currentGameBoard) {
        if (emptyCells == 0 && !(isWinner(currentGameBoard, name))) {
            printer.printDraw();
        } else {
            printer.printWinner(name);
        }
    }
}