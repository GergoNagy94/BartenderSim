package com.codecool.data;

public class Customer {
    private int id;
    private final String name;
    private int drunkness = 0;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
