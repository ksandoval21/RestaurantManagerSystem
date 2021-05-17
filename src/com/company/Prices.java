package com.company;

public class Prices {
    int adultPrice = 10;
    int kidPrice = 5;
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

