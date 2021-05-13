package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Employee newEmployee = new Employee();
        Scanner scan = new Scanner(System.in);
	    System.out.println("Welcome! If you are an employee please select [1]. " +
            "If you are a customer please select [2]. ");
	    Boolean valid = true;
        while (valid){
            System.out.print("> ");
            int input = scan.nextInt();
            switch (input) {
                case 1 -> {
                    valid = false;
                    System.out.println("Are you a manager or waitress? ");
                    System.out.print("> ");
                    String  answer = scan.next();
                    if (answer.equals("manager")){
                        System.out.println("Do you want to add or remove menu items");
                        newEmployee.manager();
                    }else if (answer.equals("waitress")){
                        System.out.println("Do you want to place and order or add to an existing order ");
                        newEmployee.waitress();
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
