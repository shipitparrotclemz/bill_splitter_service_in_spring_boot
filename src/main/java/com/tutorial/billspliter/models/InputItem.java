package com.tutorial.billspliter.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.ArrayList;

public class InputItem {
    public String name;
    public Double price;
    public Integer quantity;
    public ArrayList<InputUser> users;

    @JsonCreator
    public InputItem(String name, Double price, Integer quantity, ArrayList<InputUser> users) {
        super();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.users = users;
    }
}
