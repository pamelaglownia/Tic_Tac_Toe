package com.glownia.pamela;

import java.util.Scanner;

public class Input {
    Scanner scan = new Scanner(System.in);

    int[] inputCoordinates() {
        System.out.print("Enter the coordinates separate with space (numbers from 1 to 3): ");
        String userInput = scan.nextLine();
        while (!(userInput.substring(0, 1).matches("[0-9]+") || userInput.substring(2, 3).matches("[0-9]+"))) {
            System.out.println("You should enter numbers!");
            System.out.print("Enter the coordinates:");
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