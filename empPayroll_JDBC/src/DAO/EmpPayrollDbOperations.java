package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

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
        con.close();
        return ls;
    }

    @Override
    public void update() throws SQLException {
        Scanner sc = new Scanner(System.in);
        double empId = sc.nextDouble();
       String query = "update emppayroll set name=? where id=?";
       PreparedStatement ps = con.prepareStatement(query);
       ps.setString(1,"terresa");
       ps.setInt(2,6);
       ps.executeUpdate();
       System.out.println("enter salary");
            double baseSal = sc.nextDouble();
            double deduction = baseSal * 0.2;
            double taxable = baseSal - deduction;
            double tax = taxable * 0.1;
            double netPay = baseSal - tax;
            String queryNext2 = "update emppayroll_details set basePay=?,deducion=?,taxablePay=?,tax=?,netPay=?";
            PreparedStatement pst2 = con.prepareStatement(queryNext2);
            pst2.setDouble(1,empId);
            pst2.setDouble(2,baseSal);
            pst2.setDouble(3, deduction);
            pst2.setDouble(4,taxable);
            pst2.setDouble(5,tax);
            pst2.setDouble(6,netPay);
        con.close();
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
        con.close();
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
        con.close();
    }

    

    @Override
    public void addEmpToPayrollAndDepartmentAndToPayrollDetails() throws SQLException {
        try{
            con.setAutoCommit(false);
            int empId=0;
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

            String querryNext = "SELECT id FROM emppayroll ORDER BY id DESC LIMIT 1";
            PreparedStatement pst = con.prepareStatement(querryNext);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                EmpPayrollData emp = new EmpPayrollData();
                empId = emp.setEmp_id(rs.getInt("id"));
            } 
            
            System.out.println("enter salary");
            double baseSal = sc.nextDouble();
            double deduction = baseSal * 0.2;
            double taxable = baseSal - deduction;
            double tax = taxable * 0.1;
            double netPay = baseSal - tax;
            String queryNext2 = "insert into emppayroll_details (empId,basePay,deduction,taxablePay,tax,netPay) values(?,?,?,?,?,?)";
            PreparedStatement pst2 = con.prepareStatement(queryNext2);
            pst2.setInt(1,empId);
            pst2.setDouble(2,baseSal);
            pst2.setDouble(3, deduction);
            pst2.setDouble(4,taxable);
            pst2.setDouble(5,tax);
            pst2.setDouble(6,netPay);
            pst2.executeUpdate();

            System.out.println("enter department id");
            double did = sc.nextDouble();
            System.out.println("enter department name");
            String dname = sc.nextLine();
            String queryNext3 = "insert into department (did,dname,empId) values(?,?,?)";
            PreparedStatement pst3 = con.prepareStatement(queryNext3);
            pst3.setDouble(1,did);
            pst3.setString(2,dname);
            pst3.setDouble(3, empId);
            pst3.executeUpdate();
            con.commit();
        }catch(SQLException e){
            e.printStackTrace();
            if(con!=null)
            con.rollback();
        }finally{
            con.close();
        }
    }
}
