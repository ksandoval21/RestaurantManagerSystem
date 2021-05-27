package com.company;

import java.sql.SQLException;
import java.util.*;

public class Employee {
    Scanner scan = new Scanner(System.in);
    ArrayList<Order> list = new ArrayList<>();
    Prices prices = new Prices();
    ArrayList<String> drinks = new ArrayList<>();

    public void addOrder(Order order){
        list.add(order);
    }

    public void getTotal(int input){
        for (Order order : list) {
            if (input == order.tableNumber) {
                double guestTotal = order.guest * prices.adultPrice;
                double kidTotal = order.kids * prices.kidPrice;
                double drinkTotal = drinks.size() * prices.drinkCost;
                double total = guestTotal + kidTotal + drinkTotal;
                System.out.println(order);
                System.out.println("Your total is: " + total);
            }
        }
    }
    public void getDrinks(int total){
        for (int i = 1; i < total + 1; i++) {
            System.out.println("What would guest "+ i + " like to drink? ");
            String answer = scan.next();
            if (!answer.equals("water")) {
                drinks.add(answer);
            }
        }
    }
    public void getOrders() throws SQLException {
        list = databaseUtils.getOrdersFromDatabase();
        System.out.println(list);
    }
}
