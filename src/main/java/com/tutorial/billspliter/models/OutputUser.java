package com.tutorial.billspliter.models;

import java.util.ArrayList;

public class OutputUser {
    public String name;
    public Double total;
    public ArrayList<OutputItem> items;

    public OutputUser(String name, Double total, ArrayList<OutputItem> items) {
        this.name = name;
        this.total = total;
        this.items = items;
    }
}
