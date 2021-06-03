package com.company;

import java.sql.SQLException;
import java.util.*;

public class Employee {
    Scanner scan = new Scanner(System.in);
    ArrayList<Order> list = new ArrayList<>();
    ArrayList<String> drinks = new ArrayList<>();

    public void addOrder(Order order){
        list.add(order);
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
}
