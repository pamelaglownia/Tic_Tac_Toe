package com.glownia.pamela;

public class GameBoard {
    Input input = new Input();
    char[][] gameBoard;

    public GameBoard() {
        this.gameBoard = new char[3][3];
    }

    char[][] createInitialGameBoard() {
        String fillingInitialCells = input.inputInitialCells();
        int counter = 0;
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = fillingInitialCells.charAt(counter);
                counter++;
            }
        }
        return gameBoard;
    }

    int[] takeCoordinates() {
        int[] coordinates = input.inputCoordinates();
        int i = coordinates[0];
        int j = coordinates[1];
        while (!(checkIfCellIsEmpty(i, j))) {
            System.out.println("This cell is occupied! Choose another one!");
            coordinates = input.inputCoordinates();
            i = coordinates[0];
            j = coordinates[1];
        }

        return coordinates;
    }

    boolean checkIfCellIsEmpty(int i, int j) {
        return gameBoard[i - 1][j - 1] == '_' || gameBoard[i - 1][j - 1] == ' ';
    }

    int countEmptyCells() {
        int emptyCells = 0;
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == '_' || gameBoard[i][j] == ' ') {
                    emptyCells += 1;
                }
            }
        }
        return emptyCells;
    }

    char move(Player player) {
        int[] correctCoordinates = takeCoordinates();
        int i = correctCoordinates[0] - 1;
        int j = correctCoordinates[1] - 1;
        gameBoard[i][j] = Character.toUpperCase(player.getName());
        return gameBoard[i][j];
    }
}
