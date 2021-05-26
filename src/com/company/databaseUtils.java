package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
                        "tableNumber, Guest , Kids, Drinks" +
                        ") " +
                        "VALUES ('" + order.getTableNumber() +
                        "', " + order.getGuest() +
                        ", '" + order.getKids() +
                        "', '" +String.join("," , order.getDrinks())+
                        "')"
        );
    }
    public static ArrayList<Integer> getTableNumbers() throws SQLException {
        connect();
        var statement = conn.createStatement();
        var data = statement.executeQuery("SELECT * FROM Orders");
        ArrayList<Integer> tableNumbers = new ArrayList<>();
        while (data.next()) {
            tableNumbers.add(data.getInt("Tablenumber"));
        }
        System.out.println("Occupied tables are " + tableNumbers);
        return tableNumbers;
    }

    public static void deleteOrder(int table) throws SQLException {
        connect();
        String deleteString = "DELETE FROM Orders WHERE tableNumber=?";
        PreparedStatement deleteOrder = conn.prepareStatement(deleteString);
        deleteOrder.setInt(1, table);
        deleteOrder.executeUpdate();
    }

    public static ArrayList<Order> getOrdersFromDatabase() throws SQLException {
        connect();
        var statement = conn.createStatement();
        var data = statement.executeQuery("SELECT * FROM Orders");
        ArrayList<Order> orders = new ArrayList<>();
        while (data.next()) {
            orders.add(new Order(data.getInt("tableNumber"),
                    data.getInt("Guest"),
                    data.getInt("Kids"),
                    new ArrayList<String>(Arrays.asList((data.getString("Drinks").split(","))))));
        }
        return orders;

    }
}

