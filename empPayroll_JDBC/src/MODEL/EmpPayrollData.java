package MODEL;

import java.sql.Date;

import javax.xml.crypto.Data;

public class EmpPayrollData {
    int emp_id;
    String emp_name;
    String emp_address;
    int phoneNum;
    Date startDate;
  
    public EmpPayrollData(){

    }
  
    public EmpPayrollData(String emp_name, String emp_address)
    {
        this.emp_name = emp_name;
        this.emp_address = emp_address;
    }
  
    public int getEmp_id()
    {
        return emp_id;
    }
  
    public void setEmp_id(int emp_id)
    {
        this.emp_id = emp_id;
    }
  
    public String getEmp_name()
    {
        return emp_name;
    }
  
    public void setEmp_name(String emp_name)
    {
        this.emp_name = emp_name;
    }
  
    public String getEmp_address()
    {
        return emp_address;
    }
  
    public void setEmp_address(String emp_address)
    {
        this.emp_address = emp_address;
    }
  
    
    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "EmpPayrollData [emp_address=" + emp_address + ", emp_id=" + emp_id + ", emp_name=" + emp_name
                + ", phoneNum=" + phoneNum + ", startDate=" + startDate + "]";
    }

    
}
