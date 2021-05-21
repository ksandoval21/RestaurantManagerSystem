package com.company;

public class Prices {
    int pin = 1234;

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

