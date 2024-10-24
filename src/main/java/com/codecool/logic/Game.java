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
        display.print("Welcome to our game! \nYou are a bartender serving slightly alcoholics.");
        display.print("You have " + pub.getCustomerList().size() + " customers waiting for you.");
        display.showLineBreak();
        display.showAllDrinks(pub.getDrinkList());

        do {
            //customer asks for a drink
            ArrayList<Customer> customers = pub.getCustomerList();
            RandomGenerator randomGenerator = new RandomGenerator();
            for (int i = 0; i < customers.size(); i++) {
                if(customers.get(i).isAvailable()) {
                    display.showLineBreak();
                    display.print(customers.get(i).getName() + " asks for a " + pub.getDrinkList().get(randomGenerator.generateRandomNumber(5)).getName() + "\n");
                    int drinkSelected = 0;
                    boolean barHasDrink = false;

                    while (!barHasDrink && customers.get(i).isAvailable()) {
                        display.print("The options are: ");
                        display.showValidDrinks(pub.getDrinkList());
                        drinkSelected = input.getValidDrink(pub.getDrinkList().size());
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
                        isGameOver = true;
                        System.exit(0);
                        //getprofit
                    }

                    //incerment

                    display.print("Profit earned from this drink: " + pub.getDrinkList().get(drinkSelected).getPrice());
                    //display all profit
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
                        isGameOver = true;
                        System.exit(0);
                    }
                }
            }
            // bartender gives drink or not
            //display profit
        } while (!isGameOver);
    }


    public ArrayList<Customer> generateCostumers() {
        int randomNumber = random.generateRandomNumber(5);

        String[] names = {"Dani", "Laci", "Mari", "Mata", "Kati", "Sanyi"};
        ArrayList<Customer> customers = new ArrayList<>();

        for (int i = 0; i < randomNumber; i++) {
            Customer customer = new Customer(names[i], i);
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
