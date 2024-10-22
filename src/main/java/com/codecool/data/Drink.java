package com.codecool.data;

public class Drink {
    private final String name;
    private final int price;
    private final int alcPercentage;
    private int amountLeft;

    public Drink(int amountLeft, int alcPercentage, int price, String name) {
        this.amountLeft = amountLeft;
        this.alcPercentage = alcPercentage;
        this.price = price;
        this.name = name;
    }
}
