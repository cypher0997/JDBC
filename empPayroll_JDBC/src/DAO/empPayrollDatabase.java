package DAO;
import java.sql.SQLException;
import java.util.List;

import MODEL.EmpPayrollData;

public interface empPayrollDatabase{
    public List<EmpPayrollData> getEmployees()
        throws SQLException;
}
