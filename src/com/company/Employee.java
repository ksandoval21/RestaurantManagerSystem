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
    public void getTotal(int input){
        for (Order order : list) {
            if (input == order.tableNumber) {
                order.guest = order.guest * prices.adultPrice;
                order.kids = order.kids * prices.kidPrice;
                double total = order.guest + order.kids;
                System.out.println("Your total is: " + total);
            }
        }
    }
    public void payBalance(int input){
        boolean found = false;
        Order toDelete = null;
        for (Order order : list){
            if (input == order.tableNumber){
                toDelete = order;
                found = true;
            }
        }
        if (!found){
            System.out.println("You do not have a balance. ");
        }
        if (list.remove(toDelete)) {
            System.out.println("Your payment was successful. ");
        }
    }
    public void viewAll() {
        for (Order order : list) {
            System.out.println("Tables filled: " +order.tableNumber +"\n");
        }
    }
    public void checkPin(int enteredPin){
        if (enteredPin == prices.pin){
            System.out.println("Welcome! ");
        }else{
            System.out.println("Pin was not correct");
            System.exit(0);

        }
    }
    }
