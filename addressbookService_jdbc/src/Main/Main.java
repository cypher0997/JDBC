package Main;

import java.sql.Connection;
import java.sql.SQLException;

import Dao.AddressBookDbOperations;
import Util.DataBaseConnection;

public class Main {
    public static void main(String[] args) throws SQLException {
        DataBaseConnection.setConnection();
        // Connection con = DataBaseConnection.getConnection();
        // AddressBookDbOperations epd = new AddressBookDbOperations();
        // epd.update(con);
        ImplementThreads t1=new ImplementThreads();
        ImplementThreads t2=new ImplementThreads();
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
    
}

class ImplementThreads extends Thread{
    public void run(){  
        AddressBookDbOperations epd = new AddressBookDbOperations();
        try {
            epd.addContactAndAddressBookTypeName();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }  
   }  
