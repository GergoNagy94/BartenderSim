package com.codecool.data;

public class Drink {
    private static int counter = 0;

    private final int id;
    private final String name;
    private final int price;
    private final int alcPercentage;
    private int amountLeft;

    public Drink(String name, int price, int alcPercentage, int amountLeft) {
        this.name = name;
        this.price = price;
        this.alcPercentage = alcPercentage;
        this.amountLeft = amountLeft;
        this.id = ++counter;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAlcPercentage() {
        return alcPercentage;
    }



    public void consumeDrink() {
        amountLeft -= 1;
    }

    public boolean checkAvailability() {
        return amountLeft > 0;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Amount left: " + amountLeft +
                ", Alcohol Percentage: " + alcPercentage + "%" +
                ", Price: " + price;
    }
}
