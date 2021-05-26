package com.company;
import java.sql.SQLException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws SQLException {
        Employee bl = new Employee();
        Scanner scan = new Scanner(System.in);

        boolean valid = true;
        System.out.println("Welcome to our buffet management system. ");
        while (valid) {
            System.out.println("If you are an employee please select [1]. " +
                    "If you are a customer please select [2]. ");
            System.out.print("> ");
            int input = scan.nextInt();
            switch (input) {
                case 1 -> {
                    boolean employeeInput = true;
                    while (employeeInput) {
                        System.out.println("Are you a manager or waitress? ");
                        System.out.print("> ");
                        String answer = scan.next();
                        if (answer.equals("manager")) {
                            System.out.println("Enter pin ");
                            int pin = scan.nextInt();
                            bl.checkPin(pin);
                            System.out.println("Do you want to change prices? ");
                            String reply = scan.next();
                            if (reply.equals("yes")) {
                                System.out.println("What price do you want to change? Adult, kid or drink price ");
                                String object = scan.next();
                                System.out.println("What do you want the new price to be? ");
                                double price = scan.nextDouble();
                                bl.updatePrice(object, price);

                            }


                        } else if (answer.equals("waitress")) {
                            boolean waitress = true;
                            System.out.println("Do you want to place and order or add to an existing order or view tables? ");
                            String order = scan.next();
                            switch (order) {
                                case "order" -> {
                                    System.out.println("Enter Table Number: ");
                                    int table = scan.nextInt();
                                    System.out.println("Enter Amount of Guest: ");
                                    int guest = scan.nextInt();
                                    System.out.println("Enter how many kids: ");
                                    int kids = scan.nextInt();
                                    int totalGuest = guest + kids;
                                    bl.getDrinks(totalGuest);
                                    Order ordered = new Order(guest, kids, table, bl.drinks);
                                    bl.addOrder(ordered);
                                    databaseUtils.addOrder(ordered);
                                    System.out.println(ordered);
                                    
                                }
                                case "existing" -> {
                                    System.out.println("Enter Table Number: ");
                                    int table = scan.nextInt();
                                    System.out.println("What do you want to update? Guest, Drinks, or Table Numbers  ");
                                    String response = scan.next();
                                    switch (response) {
                                        case "adult", "kid", "Adult", "Kid", "guest", "Guest" -> {
                                            System.out.println("Do you want to update adult or kid ");
                                            String guest = scan.next();
                                            System.out.println("What do you want to update it to ?");
                                            int newGuest = scan.nextInt();
                                            bl.updateGuest(guest, newGuest, table);
                                        }
                                        case "table", "number", "Table number", "num" -> {
                                            System.out.println("What table do you want to update it to ?");
                                            int newTable = scan.nextInt();
                                            bl.updateTableNumber(table, newTable);
                                        }
                                    }

                                }
                                case "view" -> bl.viewAll();
                                default -> System.out.println("Enter correct option.");
                            }
                        } else {
                            System.out.println("Are you a customer? ");
                            String yesOrNo = scan.next();
                            if (yesOrNo.equals("yes")) {
                                employeeInput = false;
                            } else {
                                System.out.println("please enter correct input");
                            }
                        }
                    }
                }
                case 2 -> {
                    boolean customer = true;
                    while (customer) {
                        System.out.println("Start order or pay balance or go back?  ");
                        String order = scan.next();
                        switch (order) {
                            case "order" -> {
                                System.out.println("Enter Table Number: ");
                                int table = scan.nextInt();
                                System.out.println("Enter Amount of Guest: ");
                                int guest = scan.nextInt();
                                System.out.println("Enter how many kids: ");
                                int kids = scan.nextInt();
                                int totalGuest = guest + kids;
                                bl.getDrinks(totalGuest);
                                Order ordered = new Order(guest, kids, table, bl.drinks);
                                bl.addOrder(ordered);
                                System.out.println(ordered);
                                databaseUtils.addOrder(ordered);
                            }
                            case "pay" -> {
                                System.out.println("What is your table number? ");
                                int table = scan.nextInt();
                                bl.getTotal(table);
                                bl.payBalance(table);
                            }
                            case "go back","back" -> customer = false;
                            default -> System.out.println("Enter a valid input");
                        }
                    }
                }
                    default -> System.out.println("That was an invalid option. Please try again.");
                }
            }
        }
    }

