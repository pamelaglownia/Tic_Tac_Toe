package com.glownia.pamela;

import java.util.Scanner;

public class Input {
    Scanner scan = new Scanner(System.in);

    char takeSymbolToFillGameBoard() {
        char symbol = scan.next().charAt(0);
        return symbol;
    }
}
