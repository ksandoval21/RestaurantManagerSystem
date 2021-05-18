package com.company;

import java.util.ArrayList;

public class Order {
    int guest = 0;
    int kids = 0;
    int tableNumber = 0;
    ArrayList<String> drinks = new ArrayList<>() ;

    public Order ( int guestAmount, int kidsAmount, int table, ArrayList drinksName) {
        guest= guestAmount;
        kids = kidsAmount;
        tableNumber = table;
        drinks = drinksName;

    }
    public String toString() {
        String str = """
                Guest: %s
                Kids: %s
                Table: %s
                Drinks: %s
                """.formatted(guest, kids, tableNumber, drinks);
        return str;
    }
}
