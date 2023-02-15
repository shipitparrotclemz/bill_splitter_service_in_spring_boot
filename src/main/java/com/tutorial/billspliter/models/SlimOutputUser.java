package com.tutorial.billspliter.models;

public class SlimOutputUser {
    public String name;

    public SlimOutputUser(String name) {
        this.name = name;
    }

    public SlimOutputUser(InputUser inputUser) {
        this.name = inputUser.name;
    }
}
