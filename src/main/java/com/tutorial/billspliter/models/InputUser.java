package com.tutorial.billspliter.models;

import com.fasterxml.jackson.annotation.JsonCreator;

public class InputUser {
    public String name;

    @JsonCreator
    public InputUser(String name) {
        this.name = name;
    }
}
