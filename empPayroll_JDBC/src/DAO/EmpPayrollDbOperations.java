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
}
