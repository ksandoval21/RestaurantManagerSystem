package com.company;

import java.util.*;

public class Employee {
    Scanner scan = new Scanner(System.in);
    ArrayList<Order> list = new ArrayList<>();
    Prices prices = new Prices();
    ArrayList<String> drinks = new ArrayList<>();
    public void addOrder(Order order){

        list.add(order);
    }

    public void updatePrice(String input, double price){
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
                double guestTotal = order.guest * prices.adultPrice;
                double kidTotal = order.kids * prices.kidPrice;
                double drinkTotal = drinks.size() * prices.drinkCost;
                double total = guestTotal + kidTotal + drinkTotal;
                System.out.println(order);
                System.out.println("Your total is: " + total);
            }else{
                System.out.println("You do not have a balance! ");
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
        }
    }

    public void updateGuest(String input, int people, int tableNumber){
        for (Order order : list) {
            if (tableNumber == order.tableNumber) {
                if (input.equals("adult")){
                    order.guest = people;
                }else if (input.equals("kid")){
                    order.kids = people;
                }
                System.out.println(order);
            }
        }
    }
    public void updateTableNumber(int tableNumber, int newTableNumber){
        for (Order order : list){
            if (tableNumber == order.tableNumber) {
                order.tableNumber= newTableNumber;
            }
            System.out.println(order);
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
}
