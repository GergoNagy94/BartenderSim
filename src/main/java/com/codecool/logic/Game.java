package com.codecool.logic;

import com.codecool.data.*;
import com.codecool.ui.Display;

import java.util.ArrayList;

public class Game {
    private boolean isGameOver = false;
    RandomGenerator random = new RandomGenerator();
    Pub pub = new Pub(generateCostumers(), generateDrinks());
    Display display = new Display();

    public void runGame() {
        display.print("Welcome to our game!");
        display.print("You have " + pub.getCustomerList().toArray().length + " customers waiting for you.");

        display.showAllDrinks(pub.getDrinkList());


        do {
            display.print("You have " + pub.getCustomerList().toArray().length + " customers remaining.");

        } while(!isGameOver);
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
        drinks.add(new Whisky("Whisky", 1890, 23, 10));
        drinks.add(new Beer("Beer", 1550, 5, 10));
        drinks.add(new Wine("Wine", 2390, 12, 10));
        drinks.add(new Vodka("Vodka", 1290, 23, 10));
        drinks.add(new Tequila("Tequila", 5000, 23, 10));
        drinks.add(new Gin("Gin", 1990, 23, 10));

        return drinks;
    }
}
