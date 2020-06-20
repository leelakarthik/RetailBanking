
package util;

import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class Db_Connection {
    public static Connection con = null;

    public static Connection open_Connection() throws ServletException {
        String DB_username = "root";
        String JDBC_URL = "jdbc:mysql://localhost:3306/retail_banking"+"?serverTimezone=" + TimeZone.getDefault().getID();
        try {
            con = DriverManager.getConnection(JDBC_URL, DB_username, "");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
	return con;
    }
}
