package com.codecool.data;

import java.util.ArrayList;

public class Pub {
    private ArrayList<Customer> customerList;
    private ArrayList<Drink> drinkList;
    private double profit;

    public Pub(ArrayList<Customer> customerList, ArrayList<Drink> drinkList, double profit) {
        this.customerList = customerList;
        this.drinkList = drinkList;
        this.profit = profit;
    }
    public ArrayList<Drink> getDrinkList() {
        return drinkList;
    }

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
}
