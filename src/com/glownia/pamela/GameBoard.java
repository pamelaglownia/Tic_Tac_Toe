package com.glownia.pamela;

class GameBoard {
    private Input input = new Input();
    private char[][] gameBoard;

    GameBoard() {
        this.gameBoard = new char[3][3];
    }

    char[][] createEmptyGameBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = ' ';
            }
        }
        return gameBoard;
    }

    int chooseGameOption() {
        String[] setOfUserChoice = input.inputCommand();
        return MenuOption.chooseOption(setOfUserChoice);
    }

    int[] takeCoordinates() {
        int[] coordinates = input.inputCoordinates();
        int i = coordinates[0];
        int j = coordinates[1];
        while (!(isEmptyCell(i, j))) {
            System.out.println("This cell is occupied! Choose another one!");
            coordinates = input.inputCoordinates();
            i = coordinates[0];
            j = coordinates[1];
        }
        return coordinates;
    }

    boolean isEmptyCell(int i, int j) {
        return gameBoard[i - 1][j - 1] == '_' || gameBoard[i - 1][j - 1] == ' ';
    }

    int countEmptyCells() {
        int emptyCells = 0;
        for (char[] chars : gameBoard) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '_' || chars[j] == ' ') {
                    emptyCells += 1;
                }
            }
        }
        return emptyCells;
    }
}