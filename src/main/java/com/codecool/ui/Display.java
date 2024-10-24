package com.codecool.ui;

import com.codecool.data.Drink;

import java.util.ArrayList;

public class Display {
    public void print(String text) {
        System.out.println(text);
    }

    public void showAllDrinks(ArrayList<Drink> drinks){
        for (var drink : drinks) {
            print(drink.toString());
        }
    }

    public void showValidDrinks(ArrayList<Drink> drinks){
        for (int i = 0; i < drinks.size(); i++) {
            print( i + 1 + ". - " + drinks.get(i).getName() + " - " + drinks.get(i).getPrice());
        }
    }

    public void showLineBreak() {
        print("--------------------------------------------------------------");
    }
}
