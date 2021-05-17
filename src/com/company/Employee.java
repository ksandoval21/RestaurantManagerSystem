package com.company;

import java.util.ArrayList;

public class Employee {
    ArrayList<Order> list = new ArrayList<>();
    Prices prices = new Prices();
    public void addOrder(Order order){
        list.add(order);
    }

    public void updatePrice(String input, int price){
        if (input.equals("adult")){
            prices.adultPrice = price;
        }else if (input.equals("kid")){
            prices.kidPrice = price;
        }else if (input.equals("drink")){
            prices.drinkCost = price;
        }
        System.out.println(prices);
    }
    public void getTotal(){
        for (Order order : list) {
            order.guest = order.guest * prices.adultPrice;
            order.kids = order.kids * prices.kidPrice;
            double total = order.guest + order.kids;
            System.out.println("Your total is: " +total);

        }
    }
}
