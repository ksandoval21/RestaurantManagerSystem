package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class databaseUtils {
    static String dburl = "jdbc:sqlite:src/Orders.db";
    static Connection conn;
    public static void connect() throws SQLException{
        if (conn == null) {
            conn = DriverManager.getConnection(dburl);
        }
    }
    public static void addOrder(Order order) throws SQLException {
        connect();
        var statement = conn.createStatement();
        statement.executeUpdate(
                "INSERT INTO Orders (" +
                        "Tablenumber, Guest , Kids, Drinks" +
                        ") " +
                        "VALUES ('" + order.getTableNumber() +
                        "', " + order.getGuest() +
                        ", '" + order.getKids() +
                        "', '" + order.getDrinks()+
                        "')"
        );
    }
    public static ArrayList<Integer> getTableNumbers() throws SQLException {
        connect();
        var statement = conn.createStatement();
        var data = statement.executeQuery("SELECT * FROM Orders");
        ArrayList<Integer> tableNumbers = new ArrayList<>();
        while (data.next()) {
            tableNumbers.add(data.getInt("TableNumber"));
        }
        System.out.println("Occupied tables are " + tableNumbers);
        return tableNumbers;
    }

    public static void deleteOrder(int table) throws SQLException {
        connect();
        var statement = conn.createStatement();
        statement.executeUpdate("DELETE FROM Orders WHERE TableNumber=" + table);
    }

//    public static ArrayList<Order> getOrdersFromDatabase() throws SQLException {
//        connect();
//        var statement = conn.createStatement();
//        var data = statement.executeQuery("SELECT * FROM Orders");
//        ArrayList<Order> orders = new ArrayList<>();
//        while (data.next()) {
//            orders.add(new Order(data.getInt("tableNumber"),
//                    data.getInt("Guest"),
//                    data.getInt("Kids"),
//                    data.getArray("Drinks")));
//        }
//        return orders;
//    }
}

