package com.glownia.pamela;

public class GameBoard {
    Input input = new Input();
    char[][] gameBoard;

    public GameBoard() {
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
        for (char[] chars : gameBoard) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '_' || chars[j] == ' ') {
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

    boolean isWinner(Player player) {
        //columns
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[i][0] == player.getName())) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[i][1] == player.getName())) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[i][2] == player.getName())) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }

        //rows
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[0][i] == player.getName())) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[1][i] == player.getName())) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[2][i] == player.getName())) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }

        //diagonal
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[i][i] == player.getName())) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }

        //anti-diagonal
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[i][gameBoard.length - 1 - i] == player.getName())) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }
        return false;
    }
}