package com.codecool.logic;

import com.codecool.data.Customer;
import com.codecool.data.Drink;
import com.codecool.data.Pub;
import com.codecool.ui.Display;
import com.codecool.ui.Input;

import java.util.ArrayList;

public class Game {
    private boolean isGameOver = false;
    RandomGenerator random = new RandomGenerator();
    Pub pub = new Pub(generateCostumers(), generateDrinks());
    Display display = new Display();
    Input input = new Input();


    public void runGame() {
        display.print("\n" +
                "Think you’ve got what it takes to run a pub? \uD83E\uDD14 \nYour challenge is to manage drinks \uD83C\uDF7A " +
                "and customers, keeping everyone happy without anyone passing out \uD83D\uDE35 or causing trouble \uD83D\uDE2C.\n" +
                "Serve just the right drinks to make a profit \uD83D\uDCB8 , and win by sending everyone home happy. \nRun out of booze, make a " +
                "customer mad, or let someone pass out, and you’re out!\n" +
                "⚠\uFE0F Remember your drink amount, you will only see it once!⚠\uFE0F ");
        display.print("You have " + pub.getCustomerList().size() + " customer(s) waiting for you.");
        display.showLineBreak();
        display.showAllDrinks(pub.getDrinkList());

        do {
            ArrayList<Customer> customers = pub.getCustomerList();
            RandomGenerator randomGenerator = new RandomGenerator();
            for (int i = 0; i < customers.size(); i++) {
                if(customers.get(i).isAvailable()) {
                    display.showLineBreak();
                    display.print(customers.get(i).getName() + " asks for a " + pub.getDrinkList().get(randomGenerator.generateRandomNumber(5)).getName() + "\n");
                    int drinkSelected = 0;
                    boolean barHasDrink = false;

                    while (!barHasDrink && customers.get(i).isAvailable()) {
                        display.print("\tThe options are: ");
                        display.showValidDrinks(pub.getDrinkList());
                        drinkSelected = input.getValidDrink(pub.getDrinkList().size(), customers.get(i).getName());
                        if (pub.getDrinkList().contains(pub.getDrinkList().get(drinkSelected))) {
                            customers.get(i).setDrunkenness(pub.getDrinkList().get(drinkSelected).getAlcPercentage());
                            display.print(String.valueOf(customers.get(i).getDrunkenness()));
                            barHasDrink = true;
                        }
                    }

                    if (pub.getDrinkList().get(drinkSelected).checkAvailability()) {
                        pub.getDrinkList().get(drinkSelected).consumeDrink();
                        switch (customers.get(i).getStatus()) {
                            case "notyet":
                                break;
                            case "go":
                                customers.get(i).setAvailable(false);
                                display.print(customers.get(i).getName() + " went home.");
                                break;
                            case "lost":
                                display.print("You lost!");
                                isGameOver = true;
                                break;
                        }

                    } else {
                        display.print("You failed to do your task and promised a drink to someone when there is no drink left. You lost");
                        display.print("Today's profit : " + pub.getProfit());
                        isGameOver = true;
                        System.exit(0);
                    }
                    display.print("Added to bank: " + pub.getDrinkList().get(drinkSelected).getPrice() + " Ft");
                    //display all profit
                    pub.addToProfit(pub.getDrinkList().get(drinkSelected).getPrice());

                } else {
                    int numberOfCustomers = customers.size();
                    int counter = 0;
                    for (Customer customer : customers) {
                        if(!customer.isAvailable()) {
                            counter++;
                        }
                    }
                    if (counter == numberOfCustomers) {
                        display.print("Great day! Everyone went home");
                        display.print("Today's profit : " + pub.getProfit());
                        isGameOver = true;
                        System.exit(0);
                    }
                }
            }
        } while (!isGameOver);
    }


    public ArrayList<Customer> generateCostumers() {
        int randomNumber = random.generateRandomNumber(5);

        String[] names = {"Dani", "Laci", "Mari", "Mata", "Kati", "Sanyi"};
        ArrayList<Customer> customers = new ArrayList<>();

        for (int i = 0; i < randomNumber; i++) {
            Customer customer = new Customer(names[randomNumber], i);
            customers.add(customer);
        }
        return customers;
    }

    public ArrayList<Drink> generateDrinks() {
        ArrayList<Drink> drinks = new ArrayList<>();

        drinks.add(new Drink("Whisky", 1890, 23, 10));
        drinks.add(new Drink("Beer", 1550, 5, 10));
        drinks.add(new Drink("Wine", 2390, 12, 10));
        drinks.add(new Drink("Vodka", 1290, 26, 10));
        drinks.add(new Drink("Tequila", 5000, 27, 10));
        drinks.add(new Drink("Gin", 1990, 22, 10));

        return drinks;
    }
}
