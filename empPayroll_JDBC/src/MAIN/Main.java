package MAIN;

import java.sql.SQLException;

import DAO.EmpPayrollDbOperations;
import UTIL.DataBaseConnection;

public class Main {
    public static void main(String args[]) throws SQLException {
        DataBaseConnection.setConnection();
        EmpPayrollDbOperations op = new EmpPayrollDbOperations();
        System.out.println(op.getEmployees());
        op.update();
    }
}
