package com.company;

public class Order {
    int guest = 0;
    int tableNumber = 0;
    String drink = "";
    String  starter = "";
    String main = "";
    String dessert = "";
    public Order ( int guestAmount,int table,String drinkName, String starterName, String mainName, String dessertName) {
        guest= guestAmount;
        drink = drinkName;
        tableNumber = table;
        starter = starterName;
        main = mainName;
        dessert= dessertName;
    }
}
