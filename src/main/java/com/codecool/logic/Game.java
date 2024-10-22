package com.codecool.logic;

import com.codecool.data.Customer;
import com.codecool.data.RandomGenerator;

import java.util.ArrayList;

public class Game {
    RandomGenerator random = new RandomGenerator();

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
}
