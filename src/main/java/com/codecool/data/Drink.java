package com.codecool.data;

public class Drink {
    private static int counter = 0;

    private final int id;
    private final String name;
    private final int price;
    private final int alcPercentage;
    private int amountLeft;

    public Drink(int amountLeft, int alcPercentage, int price, String name) {
        this.amountLeft = amountLeft;
        this.alcPercentage = alcPercentage;
        this.price = price;
        this.name = name;
        this.id = ++counter;
    }
}
