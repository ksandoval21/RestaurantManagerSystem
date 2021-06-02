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
    public static void addPrice(Prices prices) throws SQLException {
        connect();
        var statement = conn.createStatement();
        statement.executeUpdate(
                "INSERT INTO Prices (" +
                        " Adult , Child, Drink, Pin" +
                        ") " +
                        "VALUES ('" + prices.getAdultPrice() +
                        "', " + prices.getKidPrice() +
                        ", '" + prices.getDrinkCost() +
                        "', '" +prices.getPin()+
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
        System.out.println(orders);
        return orders;
    }
    public static void updateTable(int table, int newTable) throws SQLException{
        connect();
        String sql = "UPDATE Orders SET TableNumber = ? WHERE TableNumber = ?";
        PreparedStatement updateTableNumber = conn.prepareStatement(sql);
        updateTableNumber.setInt(1, newTable);
        updateTableNumber.setInt(2, table);
        updateTableNumber.executeUpdate();
    }
    public static void guestNumber(int table, int newGuest) throws SQLException{
        connect();
        String sql = "UPDATE Orders SET Guest = ? WHERE TableNumber = ?";
        PreparedStatement updateTableNumber = conn.prepareStatement(sql);
        updateTableNumber.setInt(1, newGuest);
        updateTableNumber.setInt(2, table);
        updateTableNumber.executeUpdate();
    }
    public static void kidNumber(int table, int newGuest) throws SQLException{
        connect();
        String sql = "UPDATE Orders SET Kids = ? WHERE TableNumber = ?";
        PreparedStatement updateTableNumber = conn.prepareStatement(sql);
        updateTableNumber.setInt(1, newGuest);
        updateTableNumber.setInt(2, table);
        updateTableNumber.executeUpdate();
    }
    public static void updateDrinks(int table, String drinks) throws SQLException{
        connect();
        String sql = "UPDATE Orders SET Drinks = ? WHERE TableNumber = ?";
        PreparedStatement updateTableNumber = conn.prepareStatement(sql);
        updateTableNumber.setString(1, drinks);
        updateTableNumber.setInt(2, table);
        updateTableNumber.executeUpdate();
    }
    public static void updatePin(int pin, int newPin) throws SQLException{
        connect();
        String sql = "UPDATE Prices SET Pin = ? WHERE Pin = ?";
        PreparedStatement updateTableNumber = conn.prepareStatement(sql);
        updateTableNumber.setInt(1, newPin);
        updateTableNumber.setInt(2, pin);
        updateTableNumber.executeUpdate();
    }
    public static void updateAdultPrice(int pin, double adultPrice) throws SQLException{
        connect();
        String sql = "UPDATE Prices SET Adult = ? WHERE Pin = ?";
        PreparedStatement updateTableNumber = conn.prepareStatement(sql);
        updateTableNumber.setDouble(1, adultPrice);
        updateTableNumber.setInt(2, pin);
        updateTableNumber.executeUpdate();
    }
    public static void updateChildPrice(int pin, double childPrice) throws SQLException{
        connect();
        String sql = "UPDATE Prices SET Child = ? WHERE Pin = ?";
        PreparedStatement updateTableNumber = conn.prepareStatement(sql);
        updateTableNumber.setDouble(1, childPrice);
        updateTableNumber.setInt(2, pin);
        updateTableNumber.executeUpdate();
    }
    public static void updateDrinkPrice(int pin, double drinkPrice) throws SQLException{
        connect();
        try {
            String sql = "UPDATE Prices SET Drink = ? WHERE Pin = ?";
            PreparedStatement updateTableNumber = conn.prepareStatement(sql);
            updateTableNumber.setDouble(1, drinkPrice);
            updateTableNumber.setInt(2, pin);
            updateTableNumber.executeUpdate();
        }
        catch(Exception e) {
            System.out.println("Incorrect PIN");
        }

    }
    public static ArrayList<Order> getOrder(int table)throws SQLException{
        connect();
        var statement = conn.createStatement();
        var data = statement.executeQuery("SELECT * FROM Orders WHERE TableNumber ="+ table);
        ArrayList<Order> orders = new ArrayList<>();
        while (data.next()) {
            orders.add(new Order(data.getInt("Guest"),
                    data.getInt("Kids"),
                    data.getInt("tableNumber"),
                    new ArrayList<String>(Arrays.asList((data.getString("Drinks").split(","))))));
        }
        System.out.println(orders);
        return orders;
    }
    public static void deletePrices() throws SQLException {
        connect();
        var statement = conn.createStatement();
        var data = statement.executeUpdate("DELETE FROM Prices ");
    }

    public static ArrayList<Prices> getPrice() throws SQLException {
        connect();
        var statement = conn.createStatement();
        var data = statement.executeQuery("SELECT * FROM Prices");
        ArrayList<Prices> price = new ArrayList<>();
        while (data.next()) {
            price.add(new Prices(data.getInt("pin"),
                    data.getDouble("Adult"),
                    data.getDouble("Child"),
                    data.getDouble("Drink")));
        }
        System.out.println(price);
        return price;
    }
}

