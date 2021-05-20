package Dao;
import java.sql.SQLException;
import java.util.List;

import Model.EmpPayrollData;


public interface EmpPayrollDatabaseInterface{
    public List<EmpPayrollData> getEmployees() throws SQLException;
    public void update() throws SQLException;
    public List<EmpPayrollData> getEmpDetailsViaName() throws SQLException;
    public void empViaJoinDate() throws SQLException;
    public void addEmpToPayroll() throws SQLException;
}
