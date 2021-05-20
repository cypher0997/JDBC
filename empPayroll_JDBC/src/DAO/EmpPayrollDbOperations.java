package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.EmpPayrollData;
import Util.DataBaseConnection;



public class EmpPayrollDbOperations implements EmpPayrollDatabaseInterface{
    static Connection con = DataBaseConnection.getConnection();
    
    @Override
    public List<EmpPayrollData> getEmployees() throws SQLException {
        String query = "select * from emppayroll";
        PreparedStatement ps
            = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<EmpPayrollData> ls = new ArrayList();
  
        while (rs.next()) {
            EmpPayrollData emp = new EmpPayrollData();
            emp.setEmp_id(rs.getInt("id"));
            emp.setEmp_name(rs.getString("name"));
            emp.setEmp_address(rs.getString("address"));
            emp.setPhoneNum(rs.getInt("pno"));
            emp.setStartDate(rs.getDate("start"));
            ls.add(emp);
        }
        return ls;
    }

    @Override
    public void update() throws SQLException {
       String query = "update emppayroll set name=? where id=?";
       PreparedStatement ps = con.prepareStatement(query);
       ps.setString(1,"terresa");
       ps.setInt(2,6);
       ps.executeUpdate();
       String query1 = "update salary set ammount=? where empID=? and did=?";
       PreparedStatement ps1 = con.prepareStatement(query1);
       ps1.setString(1,"3000000");
       ps1.setInt(2,6);
       ps1.setInt(3,1);
       ps1.executeUpdate();

    }
    
    @Override
    public List<EmpPayrollData> getEmpDetailsViaName() throws SQLException {
        String query = "select * from emppayroll where name=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,"p1");
        ResultSet rs = ps.executeQuery();
        List<EmpPayrollData> ls = new ArrayList();
  
        while (rs.next()) {
            EmpPayrollData emp = new EmpPayrollData();
            emp.setEmp_id(rs.getInt("id"));
            emp.setEmp_name(rs.getString("name"));
            emp.setEmp_address(rs.getString("address"));
            emp.setPhoneNum(rs.getInt("pno"));
            emp.setStartDate(rs.getDate("start"));
            ls.add(emp);
        }
        return ls;
    }

    @Override
    public void empViaJoinDate() throws SQLException {
        String query = "select * from emppayroll where start<=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,"2015-12-21");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("address"));
            System.out.println(rs.getInt("pno"));
        }
    }

    

    @Override
    public void addEmpToPayroll() throws SQLException {
        String query = "insert into emppayroll (name,start,pno,address) values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.println("enter name");
        String name = sc.nextLine(); 
        System.out.println("enter startdate");
        String date = sc.nextLine();
        Date dateNew = Date.valueOf(date);
        System.out.println("enter address");
        String address = sc.nextLine();
        System.out.println("enter phoneNumber");
        int phoneNumber = sc.nextInt();
        ps.setString(1,name);
        ps.setDate(2,dateNew);
        ps.setInt(3, phoneNumber);
        ps.setString(4,address);
        ps.executeUpdate();
    }
}
