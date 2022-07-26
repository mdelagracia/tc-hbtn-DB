import java.sql.*;
import java.util.Enumeration;

import static oracle.jdbc.OracleDriver.getDriverVersion;

public class PrintJDBCDrivers {
    public static void main(String args[]) {
        try {

            Enumeration<Driver> e = DriverManager.getDrivers();

            while(e.hasMoreElements()){
                Driver driver = e.nextElement();
                System.out.println(driver.getMajorVersion());
                System.out.println(driver.getClass());
            }





        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

