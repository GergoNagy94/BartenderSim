package com.codecool.ui;

import java.util.Scanner;

public class Input {

    private String getDrinkFromUser(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a drink for " + name + ": ");
        return scanner.nextLine();
    }

    private boolean isUserInputValid(int maxValue, int userInput) {
        return userInput >= 1 && userInput <= maxValue;
    }

    public int getValidDrink(int maxValue, String name) {
        boolean isValid = false;
        String userInput = "";
        while (!isValid) {
            try {
                userInput = getDrinkFromUser(name);
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

    private int getValidAction() {
        boolean isValid = false;
        Scanner scanner = new Scanner(System.in);
        int answer = 0;
        while (!isValid) {
            try {
                System.out.print("Select action: ");
                String input = scanner.nextLine().toLowerCase();
                if (input.equals("exit") || input.equals("quit")) {
                    System.exit(0);
                }
                answer = Integer.parseInt(input);
                if (answer <= 5 && answer > 0) {
                    isValid = true;
                } else {
                    System.out.println("Invalid action");
                }
            } catch (Exception e) {
                System.out.println("Invalid action");
            }
        }
        return answer;

    }
}
