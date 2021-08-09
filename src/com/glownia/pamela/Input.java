package com.glownia.pamela;

import java.util.Scanner;

public class Input {
    Scanner scan = new Scanner(System.in);

    String inputInitialCells() {
        System.out.print("Enter the cells: ");
        String fillingInitialCells = scan.next();
        for (int i = 0; i < fillingInitialCells.length(); i++) {
            if (!(fillingInitialCells.substring(i, i + 1).equalsIgnoreCase("X") || fillingInitialCells.substring(i, i + 1).equalsIgnoreCase("O") || fillingInitialCells.substring(i, i + 1).equalsIgnoreCase("_"))) {
                while (!(fillingInitialCells.substring(i, i + 1).equalsIgnoreCase("x") || fillingInitialCells.substring(i, i + 1).equalsIgnoreCase("o") || fillingInitialCells.substring(i, i + 1).equalsIgnoreCase("_"))) {
                    System.out.println("Wrong input. You can enter only: x, o or _");
                    fillingInitialCells = scan.next();
                }
            }
        }
        return fillingInitialCells.toUpperCase();
    }
}
