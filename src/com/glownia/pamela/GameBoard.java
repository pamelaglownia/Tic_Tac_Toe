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
            System.out.println("This cell is occupied!");
            coordinates = input.inputCoordinates();
        }

        return coordinates;
    }

    boolean checkIfCellIsEmpty(int i, int j) {
        return gameBoard[i - 1][j - 1] == '_' || gameBoard[i - 1][j - 1] == ' ';
    }

    char movePlayer(char player) {
        int[] correctCoordinates = takeCoordinates();
        int i = correctCoordinates[0] - 1;
        int j = correctCoordinates[1] - 1;
        gameBoard[i][j] = Character.toUpperCase(player);
        return gameBoard[i][j];
    }
}
