package com.company;

import java.util.ArrayList;

public class Order {
    int guest = 0;
    int kids = 0;
    int tableNumber = 0;
    ArrayList drinks = new ArrayList<>() ;

    public Order ( int guestAmount, int kidsAmount, int table, ArrayList drinksName) {
        guest= guestAmount;
        kids = kidsAmount;
        tableNumber = table;
        drinks = drinksName;
    }
    public int getKids() {
        return kids;
    }

    public void setKids(int kids) {
        this.kids = kids;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public ArrayList<String> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<String> drinks) {
        this.drinks = drinks;
    }

    public int getGuest() {
        return guest;
    }

    public void setGuest(int guest) {
        this.guest = guest;
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

    public Order() {
    }
}
