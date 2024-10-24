package com.codecool.data;

import java.util.ArrayList;

public class Pub {
    private ArrayList<Customer> customerList;
    private ArrayList<Drink> drinkList;
    private double profit = 0.0;

    public Pub(ArrayList<Customer> customerList, ArrayList<Drink> drinkList) {
        this.customerList = customerList;
        this.drinkList = drinkList;
    }

    public ArrayList<Drink> getDrinkList() {
        return new ArrayList<>(drinkList);
    }

    //consume drink

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public double getProfit() {
        return profit;
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }
    public void addDrink(Drink drink) {
        drinkList.add(drink);
    }

    public void addToProfit(double moneyToAdd) {
        profit += moneyToAdd;
    };
}
