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

        display.print("Welcome to our game! \n You are a bartender serving slightly alcoholics. You have to ");
        display.print("You have " + pub.getCustomerList().size() + " customers waiting for you.");
        display.showAllDrinks(pub.getDrinkList());

        do {
            //customer asks for a drink

            // bartender gives drink or not

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
        drinks.add(new Drink("Whisky", 1890, 23, 10));
        drinks.add(new Drink("Beer", 1550, 5, 10));
        drinks.add(new Drink("Wine", 2390, 12, 10));
        drinks.add(new Drink("Vodka", 1290, 26, 10));
        drinks.add(new Drink("Tequila", 5000, 27, 10));
        drinks.add(new Drink("Gin", 1990, 22, 10));
        return drinks;
    }
}
