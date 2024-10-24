package com.codecool.data;

public class Customer {
    private int id;
    private final String name;
    private int drunkenness = 0;
    private String[] states = {
            "Please give me something to drink Sir!",
            "It will be hmmm... your favorite!",
            "Toss me a drink Bud!",
            "Another One!",
            "GimEE sth...just a little bbit SURE!"
    };

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getDrunkenness() {
        return drunkenness;
    }

    public void setDrunkenness(int drunkenness) {
        if (drunkenness < 100 && drunkenness >= 0) {
            this.drunkenness += drunkenness;
        }
    }

    public String getStates() {
        return switch (drunkenness / 5) {
            case 0 -> states[0];
            case 1 -> states[1];
            case 2 -> states[2];
            case 3 -> states[3];
            default -> states[4];
        };
    }

    public String getStatus() {
        String status = "";
        if (drunkenness <= 69) {
            status = "notyet";
        } else if (drunkenness <= 89) {
            status = "go";
        } else if (drunkenness <= 99) {
            status = "notyet";
        } else if(drunkenness >= 100){
            status = "lost";
        }
        return status;
    }
}
