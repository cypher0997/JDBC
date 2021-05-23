package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Model.AddressBookData;
import Util.DataBaseConnection;



public class AddressBookDbOperations implements AddressBookDbInterface{
    static Connection con = DataBaseConnection.getConnection();
    
    @Override
    public void update(Connection conTake) throws SQLException {
        
        MethodDefinitions md = new MethodDefinitions();
        md.setAttributes();
        try{
            conTake.setAutoCommit(false);
            String query = "update emppayroll set first_name=?,last_name=?,address=?,city=?,state=?,zip=?,phone_number=?,email=?";
            PreparedStatement ps = conTake.prepareStatement(query);
            ps.setString(1,md.getFname());
            ps.setString(2,md.getLname());
            ps.setString(3,md.getAddress());
            ps.setString(4,md.getCity());
            ps.setString(5,md.getState());
            ps.setInt(6,md.getZip());
            ps.setInt(7,md.getPhone_number());
            ps.setString(8,md.getEmail());
            ps.executeUpdate();
            
            conTake.commit();
        }catch(SQLException e){
            e.printStackTrace();
            if(conTake != null)
                conTake.rollback();
        }finally{
            conTake.close();
        }
    }

    @Override
    public int empCheckId(Connection conTake) throws SQLException {
        int empId=0;
        try{
            String querryNext = "SELECT id FROM addressbook_table ORDER BY id DESC LIMIT 1";
            PreparedStatement pst = conTake.prepareStatement(querryNext);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                AddressBookData emp = new AddressBookData();
                empId = emp.setEmp_id(rs.getInt("id"));
            } 
        }catch(SQLException e){
            e.printStackTrace();
        }
        return empId;
    }

    @Override
    public int empCheckcity(Connection conTake) throws SQLException {
        int cityCount=0;
        try{
            String querryNext = "select count(city) as rowCount from addressbook_table";
            PreparedStatement pst = conTake.prepareStatement(querryNext);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                AddressBookData emp = new AddressBookData();
                cityCount = emp.setCityCount(rs.getInt("rowCount"));
            } 
        }catch(SQLException e){
            e.printStackTrace();
        }
        return cityCount;
    }

    @Override
    public void addContactAndAddressBookTypeName() throws SQLException {
            try{
            con.setAutoCommit(false);
            int empId=0;
            MethodDefinitions md = new MethodDefinitions();
            String query = "insert into addressbook_table(first_name,last_name,address,city,state,zip,phone_number,email) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            md.setAttributes();
            ps.setString(1,md.getFname());
            ps.setString(2,md.getLname());
            ps.setString(3,md.getAddress());
            ps.setString(4,md.getCity());
            ps.setString(5,md.getState());
            ps.setInt(6,md.getZip());
            ps.setInt(7,md.getPhone_number());
            ps.setString(8,md.getEmail());
            ps.executeUpdate();
            
            String querryNext = "SELECT id FROM addressbook_table ORDER BY id DESC LIMIT 1";
            PreparedStatement pst = con.prepareStatement(querryNext);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                AddressBookData addressBookData = new AddressBookData();
                empId = addressBookData.setEmp_id(rs.getInt("id"));
            } 
            String queryNext = "insert into addressbook_type_name(id,addressbook_name,addressbook_type) values(?,?,?)";
            PreparedStatement pstNew = con.prepareStatement(queryNext);
            md.setAddressbook_name();
            md.setAddressbook_type();
            pstNew.setInt(1, empId);
            pstNew.setString(2, md.getAddressbook_name());
            pstNew.setString(3, md.getAddressbook_type());
            pstNew.executeUpdate();    
            con.commit();
        }catch(SQLException e){
            e.printStackTrace();
            if(con!=null)
            con.rollback();
        }
    }
}

