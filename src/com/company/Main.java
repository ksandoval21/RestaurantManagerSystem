package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Employee bl = new Employee();
        Scanner scan = new Scanner(System.in);
	    System.out.println("Welcome! If you are an employee please select [1]. " +
            "If you are a customer please select [2]. ");
	    boolean valid = true;
        while (valid){
            System.out.print("> ");
            int input = scan.nextInt();
            switch (input) {
                case 1 -> {
                    valid = false;
                    System.out.println("Are you a manager or waitress? ");
                    System.out.print("> ");
                    String answer = scan.next();
                    if (answer.equals("manager")){
                        System.out.println("Do you want to add or remove menu items");

                    }else if (answer.equals("waitress")){
                        System.out.println("Do you want to place and order or add to an existing order ");
                        String order = scan.next();
                        if (order.equals("order")){
                            System.out.println("Enter Table Number: ");
                            int tableNumeber = scan.nextInt();
                            System.out.println("Enter Amount of Guest: ");
                            int guestNumeber = scan.nextInt();
                            System.out.println("Enter Drink: ");
                            String drink = scan.next();
                            System.out.println("Enter Starter: ");
                            String starter = scan.next();
                            System.out.println("Enter Main Course: ");
                            String main = scan.next();
                            System.out.println("Enter Dessert: ");
                            String dessert = scan.next();
                            Order ordered = new Order(tableNumeber, guestNumeber,drink, starter, main, dessert);
                            bl.addOrder(ordered);
                        }

                    }

                }
                case 2 -> {
                    valid = false;
                    System.out.println("Do you want to call your waitress to place an order or get check?  ");

                }
                default -> System.out.println("That was an invalid option. Please try again.");
            }
        }
    }
}
