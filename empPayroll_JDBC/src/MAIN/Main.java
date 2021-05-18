package MAIN;

import UTIL.DataBaseConnection;

public class Main {
    public static void main(String args[]) {
        DataBaseConnection.setConnection();
        DataBaseConnection dbc = new DataBaseConnection();
        dbc.driversList();
    }
}
