package MAIN;

import java.sql.SQLException;
import java.util.*;

import DAO.EmpPayrollDbOperations;
import MODEL.EmpPayrollData;
import UTIL.DataBaseConnection;

public class Main {
    public static void main(String args[]) throws SQLException {
        DataBaseConnection.setConnection();
        EmpPayrollDbOperations op = new EmpPayrollDbOperations();
        System.out.println(op.getEmployees());
        op.update();
        System.out.println(op.getEmpDetailsViaName());
    }
}
