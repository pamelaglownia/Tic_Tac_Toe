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

    char easyMove(char[][] currentGameBoard, GameBoard gameBoard) {
        int[] correctCoordinates = takeRandomCoordinatesForComputerPlayer(gameBoard);
        int i = correctCoordinates[0] - 1;
        int j = correctCoordinates[1] - 1;
        currentGameBoard[i][j] = Character.toUpperCase(getName());
        return currentGameBoard[i][j];
    }

    char mediumMove(char[][] currentGameBoard, GameBoard gameBoard) {
        //set temporary name
        int bestI = 0;
        int bestJ = 0;
        int emptyCells = gameBoard.countEmptyCells();
        if (getName() == 'X') {
            setName('O');
        } else {
            setName('X');
        }
        for (int i = 0; i < currentGameBoard.length; i++) {
            for (int j = 0; j < currentGameBoard[i].length; j++) {
                if (currentGameBoard[i][j] == ' ') {
                    currentGameBoard[i][j] = getName();
                    if (emptyCells >= 8 || isWinner(currentGameBoard)) {
                        bestI = i;
                        bestJ = j;
                    }

                    currentGameBoard[i][j] = ' ';
                }
            }
        }

        //restore proper name
        if (getName() == 'X') {
            setName('O');
        } else {
            setName('X');
        }
        if (currentGameBoard[bestI][bestJ] == ' ') {
            currentGameBoard[bestI][bestJ] = Character.toUpperCase(getName());
        } else {
            easyMove(currentGameBoard, gameBoard);
        }
        return currentGameBoard[bestI][bestJ];
    }

    boolean isWinner(char[][] currentGameBoard) {
        //columns
        for (int i = 0; i < currentGameBoard.length; i++) {
            if (!(currentGameBoard[i][0] == getName())) {
                break;
            }
            if (i == currentGameBoard.length - 1) {
                return true;
            }
        }
        for (int i = 0; i < currentGameBoard.length; i++) {
            if (!(currentGameBoard[i][1] == getName())) {
                break;
            }
            if (i == currentGameBoard.length - 1) {
                return true;
            }
        }
        for (int i = 0; i < currentGameBoard.length; i++) {
            if (!(currentGameBoard[i][2] == getName())) {
                break;
            }
            if (i == currentGameBoard.length - 1) {
                return true;
            }
        }

        //rows
        for (int i = 0; i < currentGameBoard.length; i++) {
            if (!(currentGameBoard[0][i] == getName())) {
                break;
            }
            if (i == currentGameBoard.length - 1) {
                return true;
            }
        }
        for (int i = 0; i < currentGameBoard.length; i++) {
            if (!(currentGameBoard[1][i] == getName())) {
                break;
            }
            if (i == currentGameBoard.length - 1) {
                return true;
            }
        }
        for (int i = 0; i < currentGameBoard.length; i++) {
            if (!(currentGameBoard[2][i] == getName())) {
                break;
            }
            if (i == currentGameBoard.length - 1) {
                return true;
            }
        }

        //diagonal
        for (int i = 0; i < currentGameBoard.length; i++) {
            if (!(currentGameBoard[i][i] == getName())) {
                break;
            }
            if (i == currentGameBoard.length - 1) {
                return true;
            }
        }

        //anti-diagonal
        for (int i = 0; i < currentGameBoard.length; i++) {
            if (!(currentGameBoard[i][currentGameBoard.length - 1 - i] == getName())) {
                break;
            }
            if (i == currentGameBoard.length - 1) {
                return true;
            }
        }
        return false;
    }
}