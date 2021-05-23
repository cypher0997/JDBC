package Dao;
import java.sql.Connection;
import java.sql.SQLException;


public interface AddressBookDbInterface{
    public void update(Connection conTake) throws SQLException;
    public int empCheckId(Connection conTake) throws SQLException;
    public int empCheckcity(Connection conTake) throws SQLException;
    public void addContactAndAddressBookTypeName() throws SQLException;
}
