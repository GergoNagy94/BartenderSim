package com.codecool.ui;

import java.util.Scanner;

public class Input {

    private String getDrinkFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a drink: ");
        return scanner.nextLine();
    }

    private boolean isUserInputValid(int maxValue, int userInput) {
        return userInput >= 1 && userInput <= maxValue;
    }

    public int getValidDrink(int maxValue) {
        boolean isValid = false;
        String userInput = "";
        while (!isValid) {
            try {
                userInput = getDrinkFromUser();
                if (isUserInputValid(maxValue, Integer.parseInt(userInput))) {
                    isValid = true;
                } else {
                    System.out.println("Invalid drink");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid drink");
            }
        }
        return Integer.parseInt(userInput) - 1;
    }
}
