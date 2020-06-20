package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import bean.Employee;
import util.Db_Connection;

public class userDAO {
	public static boolean insertUser(Employee user) {
		boolean status = false;
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = Db_Connection.open_Connection();
			ps = con.prepareStatement("insert into employeedetails(employeeID,employeeName,employeeAge,employeeType,employeePassword) values (?,?,?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getName());
			ps.setString(3, user.getAge());
			ps.setString(4, user.getRole());
			ps.setString(5, user.getPassword());

			if (ps.executeUpdate() > 0) {
				status = true;
			}
		} catch (ServletException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}

	public static boolean getUser(Employee user) {
		boolean status = false;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = Db_Connection.open_Connection();
			ps = con.prepareStatement("select * from employeedetails where employeeID=? and employeePassword=? limit 1");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			if (rs != null && rs.next()) {
				status = true;
				user.setRole(rs.getString("employeeType"));
				user.setName(rs.getString("employeeName"));
			}
		} catch (SQLException | ServletException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null && rs != null) {
					ps.close();
					rs.close();
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}


}
