package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;


public class DataBaseConnection {
    private static Connection con = null;
  
    public static boolean setConnection(){
        String url = "jdbc:mysql:// localhost:3306/addressbookservice";
        String userName = "root";
        String password = "__anu123__rag";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("connection estabilished to :"+con);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public static Connection getConnection()
    {
        return con;
    }
    public void driversList(){
        Enumeration<java.sql.Driver> e = DriverManager.getDrivers();
        while(e.hasMoreElements()) {
            System.out.println(e.nextElement().getClass()); 
        }
    }
    
}

