package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Employee bl = new Employee();
        Scanner scan = new Scanner(System.in);
	    boolean valid = true;
	    System.out.println("Welcome to our buffet management system. ");
        while (valid){
            System.out.println("If you are an employee please select [1]. " +
                    "If you are a customer please select [2]. ");
            System.out.print("> ");
            int input = scan.nextInt();
            switch (input) {
                case 1 -> {
                    boolean employeeInput = true;
                    while (employeeInput){
                        System.out.println("Are you a manager or waitress? ");
                        System.out.print("> ");
                        String answer = scan.next();
                        if (answer.equals("manager")){
                            System.out.println("Do you want to change prices? ");
                            String reply = scan.next();
                            if (reply.equals("yes")){
                                System.out.println("What price do you want to change? Adult, kid or drink price ");
                                String object = scan.next();
                                System.out.println("What do you want the new price to be? ");
                                int price = scan.nextInt();
                                bl.updatePrice(object,price);

                            }


                        }else if (answer.equals("waitress")){
                            System.out.println("Do you want to place and order or add to an existing order ");
                            String order = scan.next();
                            if (order.equals("order")){
                                System.out.println("Enter Table Number: ");
                                int table = scan.nextInt();
                                System.out.println("Enter Amount of Guest: ");
                                int guest = scan.nextInt();
                                System.out.println("Enter Drink: ");
                                String drink = scan.next();
                                System.out.println("Enter how many kids: ");
                                int kids = scan.nextInt();
                                Order ordered = new Order(guest, kids, table, drink);
                                bl.addOrder(ordered);
                                System.out.println(ordered);
                            }else if (order.equals("existing")){
                                System.out.println("Enter Table Number: ");
                                int table = scan.nextInt();

                            }
                        }else {
                            System.out.println("Are you a customer? ");
                            String yesOrNo = scan.next();
                            if (yesOrNo.equals("yes")){
                                employeeInput= false;
                            }else{
                                System.out.println("please enter correct input");
                            }
                        }
                }}
                case 2 -> {
                    boolean customer = true;
                    while (customer) {
                        System.out.println("Start order or get check?  ");
                        String order = scan.next();
                        if (order.equals("order")) {
                            System.out.println("Enter Table Number: ");
                            int table = scan.nextInt();
                            System.out.println("Enter Amount of Guest: ");
                            int guest = scan.nextInt();
                            System.out.println("Enter Drink: ");
                            String drink = scan.next();
                            System.out.println("Enter how many kids: ");
                            int kids = scan.nextInt();
                            Order ordered = new Order(guest, kids, table, drink);
                            bl.addOrder(ordered);
                            System.out.println(ordered);
                            bl.getTotal();
                        } else if (order.equals("check")) {
                            System.out.println("What is your table number? ");
                        }

                    }
                }
                default -> System.out.println("That was an invalid option. Please try again.");
            }
        }
    }
}
