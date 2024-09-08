package com.spartanny.entities;

import lombok.Getter;

@Getter
public class Player {

    private String name;
    private String symbol;

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}
