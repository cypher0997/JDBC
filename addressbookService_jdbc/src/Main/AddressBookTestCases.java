package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import Dao.AddressBookDbOperations;
import Model.AddressBookData;
import Util.DataBaseConnection;
import junit.framework.Assert;

public class AddressBookTestCases {
    
    static Connection con;
        
   
    @Test
    @SuppressWarnings( "deprecation" )
    public void connectTest(){
        Assert.assertEquals(true,DataBaseConnection.setConnection()); 
    }

    @Test
    @SuppressWarnings( "deprecation" )
    public void testDbUpdation() throws SQLException{
        AddressBookDbOperations addressBookDbOperations = new AddressBookDbOperations(); 
        DataBaseConnection.setConnection();
        con = DataBaseConnection.getConnection();
        int empId=0;
        try{
            String querryNext = "SELECT id FROM addressbook_table ORDER BY id DESC LIMIT 1";
            PreparedStatement pst = con.prepareStatement(querryNext);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                AddressBookData emp = new AddressBookData();
                empId = emp.setEmp_id(rs.getInt("id"));
            } 
        }catch(SQLException e){
            e.printStackTrace();
        }
        Assert.assertEquals(empId,addressBookDbOperations.empCheckId(con));
    }

    @Test
    @SuppressWarnings( "deprecation" )
    public void testCityCount() throws SQLException{
        AddressBookDbOperations addressBookDbOperations = new AddressBookDbOperations(); 
        DataBaseConnection.setConnection();
        con = DataBaseConnection.getConnection();
        Assert.assertEquals(4,addressBookDbOperations.empCheckcity(con));
    }
}
