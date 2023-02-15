package com.tutorial.billspliter.models;

import java.util.ArrayList;

public class InputItem {
    public String name;
    public Double price;
    public Integer quantity;
    public ArrayList<InputUser> users;

    // This constructor is used by jackson for deserializing JSON to InputItem
    public InputItem() {
        super();
    }

    public InputItem(String name, Double price, Integer quantity, ArrayList<InputUser> users) {
        super();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.users = users;
    }
}
