package com.codecool;

import com.codecool.data.Customer;
import com.codecool.logic.Game;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        ArrayList<Customer> list = game.generateCostumers();
        for (Customer customer : list) {
            System.out.println(customer.getName());
        }
        System.out.println("!");
    }

}