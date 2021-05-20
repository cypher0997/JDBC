package Main;

import java.sql.SQLException;
import java.text.ParseException;

import Dao.EmpPayrollDbOperations;
import Util.DataBaseConnection;
public class Main {
    public static void main(String args[]) throws SQLException, ParseException {
        DataBaseConnection.setConnection();
        EmpPayrollDbOperations op = new EmpPayrollDbOperations();
        System.out.println(op.getEmployees());
        op.update();
        System.out.println(op.getEmpDetailsViaName());
        op.empViaJoinDate();
        op.addEmpToPayroll();
    }
}
