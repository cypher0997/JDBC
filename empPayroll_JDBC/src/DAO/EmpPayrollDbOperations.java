package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MODEL.EmpPayrollData;
import UTIL.DataBaseConnection;

public class EmpPayrollDbOperations implements empPayrollDatabase{
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
    
}
