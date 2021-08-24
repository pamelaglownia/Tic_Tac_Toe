package com.glownia.pamela;

enum MenuOption {
    START, EXIT, USER, EASY, MEDIUM;

    static boolean isValid(String userChoice) {
        for (MenuOption option : MenuOption.values()) {
            if (option.name().equalsIgnoreCase(userChoice)) {
                return true;
            }
        }
        return false;
    }

    static int chooseOption(String[] setOfUserInput) {
        if (START.name().equalsIgnoreCase(setOfUserInput[0])) {
            if (USER.name().equalsIgnoreCase(setOfUserInput[1])) {
                if (USER.name().equalsIgnoreCase(setOfUserInput[2])) {
                    return 1;
                } else if (EASY.name().equalsIgnoreCase(setOfUserInput[2])) {
                    return 2;
                } else {
                    return 3;
                }
            } else if (EASY.name().equalsIgnoreCase(setOfUserInput[1])) {
                if (USER.name().equalsIgnoreCase(setOfUserInput[2])) {
                    return 2;
                } else if (EASY.name().equalsIgnoreCase(setOfUserInput[2]) || MEDIUM.name().equalsIgnoreCase(setOfUserInput[2])) {
                    return 4;
                }
            } else if (MEDIUM.name().equalsIgnoreCase(setOfUserInput[1])) {
                if (USER.name().equalsIgnoreCase(setOfUserInput[2])) {
                    return 3;
                } else if (EASY.name().equalsIgnoreCase(setOfUserInput[2]) || MEDIUM.name().equalsIgnoreCase(setOfUserInput[2])) {
                    return 4;
                }
            }
        }
        return 0;
    }
}