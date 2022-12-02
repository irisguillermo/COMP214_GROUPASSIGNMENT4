package com.example.comp214_groupassignment4;

import java.sql.*;

public class DBUtil {

    private static Connection connection = null;
    private static Statement statement = null;

    public static ResultSet dbConnect() throws SQLException {
        //Connect to database
        String dbURL = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
        String username = "COMP214_F22_ER_10"; //HEBA'S DB
        String password = "password";
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Database is connected!");
            Statement statement = connection.createStatement();
        }catch (SQLException e) {
            System.out.println("Database is not connected!");
            System.out.println(e.getMessage());
        }
        return null;
    }

    //close the database
    public static void dbDisconnect() throws SQLException{
        try {
            if (connection != null && !connection.isClosed()){
                connection.close();
                System.out.println("Database is disconnected!");
            }
        } catch (Exception e){
            throw e;
        }
    }

   public static void updateBasket (int item_code, String item_name, String item_options, int quantity, int item_price, int item_total, int item_subtotal) throws SQLException {
    dbConnect();
    try
    {
        String sql = "UPDATE" + item_code + item_name + item_options + quantity + item_price + item_total + item_subtotal;
        statement.executeUpdate(sql);
        System.out.println( item_code + item_name + item_options + quantity + item_price + item_total + item_subtotal);
    }catch(SQLException e)
    {
        System.out.println("Item updated");
        System.out.println(e.getMessage());
    }
    dbDisconnect();
   }

    public static void main(String[] args) throws SQLException {
        dbConnect();
        dbDisconnect();
    }
}
