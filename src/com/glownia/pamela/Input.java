package com.glownia.pamela;

import java.util.Scanner;

class Input {
    private Scanner scan = new Scanner(System.in);

    String[] inputCommand() {
        System.out.print("Input command separate with space: ");
        String userChoice = scan.nextLine();
        String[] setOfUserChoice = userChoice.split(" ");
        if (setOfUserChoice[0].equalsIgnoreCase((MenuOption.EXIT.name()))) {
            setOfUserChoice = new String[1];
            setOfUserChoice[0] = MenuOption.EXIT.name();
            return setOfUserChoice;
        } else if (setOfUserChoice.length != 3) {
            System.out.println("Bad parameters!");
            setOfUserChoice = inputCommand();
        } else {
            for (String userOption : setOfUserChoice) {
                if (!(MenuOption.isValid(userOption))) {
                    System.out.println("Bad parameters!");
                    setOfUserChoice = inputCommand();
                    break;
                }
            }
        }
        return setOfUserChoice;
    }

    char chooseCharacterToPlay() {
        System.out.print("Choose character [X or O]: ");
        char character = scan.next().charAt(0);
        character = Character.toUpperCase(character);
        while (!(character == 'X' || character == 'O')) {
            System.out.print("Wrong input. Choose character [X or O]: ");
            character = scan.next().charAt(0);
        }
        scan.nextLine();
        return character;
    }

    int[] inputCoordinates() {
        System.out.print("Enter the coordinates separate with space (numbers from 1 to 3). Example: to choose coordinates [1,1] type: \"1 1\": ");
        String userInput = scan.nextLine();
        while (userInput.length() != 3 || (!(userInput.substring(0, 1).matches("[0-9]+") || userInput.substring(2, 3).matches("[0-9]+")))) {
            System.out.println("You should enter numbers separate with space!");
            System.out.print("Enter the coordinates: ");
            userInput = scan.nextLine();
        }
        int i = Integer.parseInt(userInput.substring(0, 1));
        int j = Integer.parseInt(userInput.substring(2, 3));
        while (!(i >= 1 && i <= 3 && j >= 1 && j <= 3)) {
            System.out.println("Coordinates should be from 1 to 3!!");
            userInput = scan.nextLine();
            i = Integer.parseInt(userInput.substring(0, 1));
            j = Integer.parseInt(userInput.substring(2, 3));
        }
        String[] tempCoordinates = userInput.split(" ");
        int[] coordinates = new int[2];
        for (int k = 0; k < tempCoordinates.length; k++) {
            coordinates[k] = Integer.parseInt(tempCoordinates[k]);
        }
        return coordinates;
    }
}