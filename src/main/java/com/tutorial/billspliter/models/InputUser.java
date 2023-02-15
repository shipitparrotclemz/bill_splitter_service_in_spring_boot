package com.tutorial.billspliter.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InputUser {
    @JsonProperty("name")
    public String name;

    public InputUser(String name) {
        this.name = name;
    }
}
