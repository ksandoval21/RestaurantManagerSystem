package com.company;

import java.util.ArrayList;

public class Prices {
    int pin = 0;
    double adultPrice = 0;
    double kidPrice = 0;
    double drinkCost = 0;

    public Prices(int enteredPin, double guest, double kids, double drinks) {
        pin = enteredPin;
        adultPrice= guest;
        kidPrice = kids;
        drinkCost= drinks;
    }

    public double getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(double adultPrice) {
        this.adultPrice = adultPrice;
    }

    public double getKidPrice() {
        return kidPrice;
    }

    public void setKidPrice(double kidPrice) {
        this.kidPrice = kidPrice;
    }

    public double getDrinkCost() {
        return drinkCost;
    }

    public void setDrinkCost(double drinkCost) {
        this.drinkCost = drinkCost;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String toString() {
        String str = """
                Adult Price: %s
                Kid Price: %s
                Drink Price: %s
                """.formatted(adultPrice, kidPrice, drinkCost);
        return str;
    }

    public Prices() {
    }
}

