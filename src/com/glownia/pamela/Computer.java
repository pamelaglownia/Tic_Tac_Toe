package com.glownia.pamela;

import java.util.Random;

public class Computer {
    private char name;

    public Computer(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    int[] takeRandomCoordinatesForComputerPlayer(GameBoard gameBoard) {
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

    char move(char[][] array, GameBoard gameBoard) {
        int[] correctCoordinates = takeRandomCoordinatesForComputerPlayer(gameBoard);
        int i = correctCoordinates[0] - 1;
        int j = correctCoordinates[1] - 1;
        array[i][j] = Character.toUpperCase(getName());
        return array[i][j];
    }

    boolean isWinner(char[][] gameBoard) {
        //columns
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[i][0] == getName())) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[i][1] == getName())) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[i][2] == getName())) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }

        //rows
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[0][i] == getName())) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[1][i] == getName())) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[2][i] == getName())) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }

        //diagonal
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[i][i] == getName())) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }

        //anti-diagonal
        for (int i = 0; i < gameBoard.length; i++) {
            if (!(gameBoard[i][gameBoard.length - 1 - i] == getName())) {
                break;
            }
            if (i == gameBoard.length - 1) {
                return true;
            }
        }
        return false;
    }
}