package Main;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import Dao.EmpPayrollDbOperations;
import Util.DataBaseConnection;
public class Main {
    public static void main(String args[]) throws SQLException, ParseException {
        DataBaseConnection.setConnection();
        EmpPayrollDbOperations op = new EmpPayrollDbOperations();
        Scanner sc = new Scanner (System.in);
        System.out.println("enter your choice"+"\n"+
                            "press 1 to add record to tables emppayroll,department,emppayroll_details"+"\n"
                            +"press 2 to retrieve employee data"+"\n"+
                            "press 3 to update employee daata on basis of 'id'"+"\n"+
                            "press 4 to get employee details via name"+"\n"+
                            "press 5 to get joing date of employee on basis of range"+"\n"+
                            "press 6 to stop");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                op.addEmpToPayrollAndDepartmentAndToPayrollDetails();
             break;

            case 2:
                System.out.println(op.getEmployees());
                break;
            
            case 3:
                op.update();
                break;
            
            case 4:
                System.out.println(op.getEmpDetailsViaName());
                break;

            case 5:
                op.empViaJoinDate();
                break;
            
            case 6:
                break;

            default:
                System.out.println("give valid input");
        }
    }
}
