package com.codecool.data;

public abstract class Drink {
    private static int counter = 0;

    private final int id;
    private final String name;
    private final int price;
    private final int alcPercentage;
    private int amountLeft;

    public Drink(String name, int price, int alcPercentage, int amountLeft) {
        this.alcPercentage = alcPercentage;
        this.price = price;
        this.name = name;
        this.amountLeft = amountLeft;
        this.id = ++counter;
    }
}
