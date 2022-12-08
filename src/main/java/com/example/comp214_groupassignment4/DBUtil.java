package com.example.comp214_groupassignment4;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.swing.*;
import java.sql.*;



public class DBUtil {

    private static Connection connection = null;
    private static Statement statement = null;

    public static Connection dbConnect() throws SQLException {
        //Connect to database
        String dbURL = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
        String username = "COMP214_F22_er_12"; //WING'S DB
        //String username = "COMP214_F22_er_26"; //WING'S DB
        //String username = "COMP214_F22_ER_10"; //HEBA'S DB
        String password = "91248120";
        //String password = "password";
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Database is connected!");
             statement = connection.createStatement();
        }catch (SQLException e) {
            System.out.println("Database is not connected!");
            System.out.println(e.getMessage());
        }
        return connection;

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

    public static void createTable(String tableName) throws SQLException{
        dbConnect();
        String sql = "CREATE TABLE " + tableName + " (item_code INTEGER PRIMARY KEY, name VARCHAR2(50), options VARCHAR2(50), quantity INTEGER, price INTEGER, total INTEGER, subtotal INTEGER)";
        try{
            statement.execute(sql);
            System.out.println("Table "+tableName+" is created");
        }catch(SQLException e){
            System.out.println("ERROR! Table is not created" + tableName);
            System.out.println(e.getMessage());
        }
    }

    public static void dropTable(String tableName) throws SQLException{
        dbConnect();
        String sql = "DROP TABLE " + tableName;

        try{
            statement.execute(sql);
            System.out.println("Table "+tableName+" is dropped");

        }catch(SQLException e){
            System.out.println("ERROR! Table is not dropped" + tableName);

            System.out.println(e.getMessage());
        }
    }

    public static void insertData(String tableName, int item_code, String name, String options, int qty, double price, double total, double subtotal) throws SQLException {
        dbConnect();
        try{
            String sql = "INSERT INTO " + tableName + " VALUES(" + item_code + ",'" + name +  "','" + options + "','" + qty + price + total + subtotal + "')";
            System.out.println(sql);
            statement.executeUpdate(sql);
            System.out.println("data is inserted into items table");
        }catch (SQLException e){
            System.out.println("ERROR! Data is not inserted into items table");
            System.out.println(e.getMessage());
        }
    }

    public static void deleteData(String tableName, int id) throws SQLException{
        dbConnect();
        try{
            String sql = "DELETE FROM " + tableName + " WHERE item_code = " + id;
            statement.executeUpdate(sql);
            System.out.println("Data is deleted from the items table!");
        }catch(SQLException e){
            System.out.println("ERROR! Data is not deleted from the items table");
            System.out.println(e.getMessage());
        }
    }

    public static ResultSet query(String sql) throws SQLException {
        CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();

        dbConnect();

        ResultSet resultSet = null;

        try {
            resultSet = statement.executeQuery(sql);
            crs.populate(resultSet);

            while (resultSet.next()) {
                int id = resultSet.getInt("item_code");
                String name = resultSet.getString("item_name");
                System.out.println(id + " ," + name);
            }
        }catch (SQLException e){
            System.out.println("Query did not run!");
            System.out.println(e.getMessage());
        }
        if(statement != null){
            statement.close();
        }
        dbDisconnect();
        return crs;
    }


    public static void main(String[] args) throws SQLException {
        dbConnect();
        dbDisconnect();
       // dropTable("ItemTable");
        createTable(" Item-Table");
        //insertData("Item-Table",2,"items","none",3,45,50,52);
   }
}
