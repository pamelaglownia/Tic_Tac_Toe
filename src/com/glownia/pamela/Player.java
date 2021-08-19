package com.glownia.pamela;

class Player {

    private char name;

    char getName() {
        return name;
    }

    void setName(char name) {
        this.name = name;
    }

    void setPlayerName() {
        Input input = new Input();
        char name = input.chooseCharacterToPlay();
        setName(name);
    }

    char move(GameBoard gameBoard, char[][] currentGameBoard) {
        int[] correctCoordinates = gameBoard.takeCoordinates();
        int i = correctCoordinates[0] - 1;
        int j = correctCoordinates[1] - 1;
        currentGameBoard[i][j] = Character.toUpperCase(getName());
        return currentGameBoard[i][j];
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