package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class databaseUtils {
    static String dburl = "jdbc:sqlite:src/database.db";
    static Connection conn;
    public static void connect() throws SQLException{
        if (conn == null) {
            conn = DriverManager.getConnection(dburl);
        }
    }
    public static void addOrderToDatabase(Order order) throws SQLException {
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

}
