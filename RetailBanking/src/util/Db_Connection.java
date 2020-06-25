
package util;

import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class Db_Connection {
    public static Connection con = null;

    public static Connection open_Connection() throws ServletException {
        try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String JDBC_URL = "jdbc:mysql://db4free.net:3306/retail_banking?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";      
	        con = DriverManager.getConnection(JDBC_URL, "retail", "retailbanking");
	        System.out.println("sucess");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println(con);
	return con;
    }
}

