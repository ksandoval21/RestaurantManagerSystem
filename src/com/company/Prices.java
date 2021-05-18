package com.company;

public class Prices {
    int pin = 1234;
    double adultPrice = 10;
    double kidPrice = 5;
    double drinkCost = 2.5;

    public String toString() {
        String str = """
                Adult Price: %s
                Kid Price: %s
                Drink Price: %s
                """.formatted(adultPrice, kidPrice, drinkCost);
        return str;
    }
}

