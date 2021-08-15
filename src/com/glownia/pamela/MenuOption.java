package com.glownia.pamela;

public enum MenuOption {
    START, EXIT, USER, EASY;

    static MenuOption equals(String userChoice) {
        for (MenuOption option : MenuOption.values()) {
            if (option.name().equalsIgnoreCase(userChoice)) {
                return option;
            }
        }
        return null;
    }
}
