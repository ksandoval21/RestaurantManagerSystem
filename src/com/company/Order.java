package com.company;

public class Order {
    int guest = 0;
    int kids = 0;
    int tableNumber = 0;
    String drink = "";

    public Order ( int guestAmount, int kidsAmount, int table,String drinkName) {
        guest= guestAmount;
        kids = kidsAmount;
        tableNumber = table;
        drink = drinkName;

    }
    public String toString() {
        String str = """
                Guest: %s
                Kids: %s
                Table: %s
                Drink: %s
                """.formatted(guest, kids, tableNumber, drink);
        return str;
    }
}
