package com.glownia.pamela;

enum MenuOption {
    START, EXIT, USER, EASY, MEDIUM;

    static MenuOption equals(String userChoice) {
        for (MenuOption option : MenuOption.values()) {
            if (option.name().equalsIgnoreCase(userChoice)) {
                return option;
            }
        }
        return null;
    }
}