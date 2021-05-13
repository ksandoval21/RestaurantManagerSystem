package com.company;

import java.util.ArrayList;

public class Employee {
    ArrayList<Order> list = new ArrayList<>();
    public void addOrder(Order order){
        list.add(order);
    }

    public void addToOrder(){
       System.out.println("Hello");
    }
}
