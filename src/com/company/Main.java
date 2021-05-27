package com.company;
import java.sql.SQLException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws SQLException {
        Employee bl = new Employee();
        Scanner scan = new Scanner(System.in);
        boolean valid = true;
        System.out.println("Welcome to our management system. ");
        while (valid) {
            System.out.println("If you are an employee please select [A]. " +
                    "If you are a customer please select [B]. Enter [Q] to quit. ");
            System.out.print("> ");
            String input = scan.next();
            switch (input) {
                case "A", "a", "employee" -> {
                    boolean employeeInput = true;
                    while (employeeInput) {
                        System.out.println("Are you a manager or waitress? ");
                        System.out.print("> ");
                        String answer = scan.next();
                        if (answer.equals("manager")) {
                            System.out.println("What do you want to update? [pin, adult, child or drink] ");
                            String response = scan.next();
                            switch (response){
                                case "update pin", "pin"->{
                                    System.out.println("Enter pin ");
                                    int pin = scan.nextInt();
                                    System.out.println("Enter new pin ");
                                    int newPin = scan.nextInt();
                                    databaseUtils.updatePin(pin,newPin );
                                }
                                case "adult","guest","Adult","Guest"->{
                                    System.out.println("Enter pin ");
                                    int pin = scan.nextInt();
                                    System.out.println("Enter new child price ");
                                    double newAdult = scan.nextDouble();
                                    databaseUtils.updateAdultPrice(pin,newAdult);
                                }
                                case  "kid", "Kid", "child" -> {
                                    System.out.println("Enter pin ");
                                    int pin = scan.nextInt();
                                    System.out.println("Enter new adult price ");
                                    double newChild = scan.nextDouble();
                                    databaseUtils.updateChildPrice(pin,newChild);
                                }
                                case "drink", "Drinks"->{
                                    System.out.println("Enter pin ");
                                    int pin = scan.nextInt();
                                    System.out.println("Enter new drink price ");
                                    double newDrink = scan.nextDouble();
                                    databaseUtils.updateDrinkPrice(pin,newDrink);
                                }
                            }

                        } else if (answer.equals("waitress")) {
                            System.out.println("a. place an order " +
                                    "b. add to existing order " +
                                    "c. view tables occupied " +
                                    "d. view all orders " +
                                    "e. view a specific order ");
                            String order = scan.next();
                            switch (order) {
                                case "order","a" -> {
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
                                case "existing","b" -> {
                                    System.out.println("Enter Table Number: ");
                                    int table = scan.nextInt();
                                    System.out.println("What do you want to update? Adult, Kids, Drinks, or Table Numbers  ");
                                    String response = scan.next();
                                    switch (response) {
                                        case  "kid", "Kid","child" -> {
                                            System.out.println("What do you want to update it to ?");
                                            int newGuest = scan.nextInt();
                                            databaseUtils.kidNumber(table,newGuest);
                                        }
                                        case "adult","guest","Adult","Guest"->{
                                            System.out.println("What do you want to update it to ?");
                                            int newGuest = scan.nextInt();
                                            databaseUtils.guestNumber(table,newGuest);
                                        }
                                        case "table", "number", "Table number", "num" -> {
                                            System.out.println("What table do you want to update it to ?");
                                            int newTable = scan.nextInt();
                                            databaseUtils.updateTable(table, newTable);
                                        }
                                        case "drink", "drinks"->{
                                            System.out.println("Enter drinks separated by a comma ?");
                                            String newDrink = scan.next();
                                            databaseUtils.updateDrinks(table, newDrink);
                                        }
                                    }

                                }
                                case "tables","c" -> {
                                    databaseUtils.getTableNumbers();
                                }
                                case "orders", "d"->{
                                    databaseUtils.getOrdersFromDatabase();
                                }
                                case "e", "specific"->{
                                    System.out.println("Enter table number");
                                    int tableNumber = scan.nextInt();
                                    databaseUtils.getOrder(tableNumber);
                                }
                                default -> System.out.println("Enter correct option.");
                            }
                        } else {
                            System.out.println("Are you a customer? ");
                            String yesOrNo = scan.next();
                            if (yesOrNo.equals("yes")) {
                                employeeInput = false;
                            }
                        }
                    }
                }
                case "B", "b", "customer2" -> {
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
                            case "view order"->{
                                System.out.println("Enter table number");
                                int tableNumber = scan.nextInt();
                                databaseUtils.getOrder(tableNumber);
                            }
                            case "pay" -> {
                                System.out.println("What is your table number? ");
                                int table = scan.nextInt();
                                bl.getOrders();
                                bl.getTotal(table);
                                databaseUtils.deleteOrder(table);
                            }
                            case "go back","back" -> customer = false;
                            default -> System.err.println("Enter a valid input");
                        }
                    }
                }
                case "quit", "q", "Q" ->{
                    System.exit(0);
                }
                    default -> System.err.println("That was an invalid option. Please try again.");
                }
            }
        }
    }

