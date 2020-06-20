package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import bean.Customer;
import util.Db_Connection;

public class CustomerDAO {
	public static boolean C_insertUser(Customer user) {
		boolean status = false;
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = Db_Connection.open_Connection();
			ps = con.prepareStatement("INSERT INTO customerdetails (customerAadhar, customerID, customerName, customerAge, customerAddress, customerState, customerCity) values (?,?,?,?,?,?,?)");
			ps.setInt(1, user.getAadharId());
			ps.setInt(2, user.getCusId());
			ps.setString(3, user.getCusName());
			ps.setInt(4, user.getCusAge());
			ps.setString(5, user.getCusAddress());
			ps.setString(6, user.getCusState());
			ps.setString(7, user.getCusCity());
			PreparedStatement p = con.prepareStatement("insert into customerstatus("
					+ "customerID, customerAadharID, customerStatus, customerMessage) "
					+ "values (?,?,?,?)");
			p.setInt(1, user.getCusId());
			p.setInt(2, user.getAadharId());
			p.setString(3, user.getCusStatus());
			p.setString(4, user.getCusMessage());
			if (ps.executeUpdate() > 0 && p.executeUpdate() > 0) {
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

	public static boolean C_searchUser(Customer user) {
		boolean status = false;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = Db_Connection.open_Connection();
			ps = con.prepareStatement("select * from customerdetails where customerID=? or customerAadhar=? ");
			ps.setInt(1, user.getCusId());
			ps.setInt(2, user.getAadharId());
			rs = ps.executeQuery();
			if (rs != null && rs.next()) {
				status = true;
				getObject_Cus(user, rs);
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

	public static boolean C_updateUser(Customer user) {
		boolean status = false;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = Db_Connection.open_Connection();
			ps = con.prepareStatement("update customerdetails set customerName = ?, customerAge = ?, customerAddress = ? where customerID = ? or customerAadhar=?");
			ps.setString(1, user.getCusName());
			ps.setInt(2, user.getCusAge());
			ps.setString(3, user.getCusAddress());
			ps.setInt(4, user.getCusId());
			ps.setInt(5, user.getAadharId());
			PreparedStatement p = con.prepareStatement("INSERT INTO customerstatus(customerID, customerAadharID, customerStatus, customerMessage) values (?,?,?,?)");
			p.setInt(1, user.getCusId());
			p.setInt(2, user.getAadharId());
			p.setString(3, user.getCusStatus());
			p.setString(4, user.getCusMessage());
			if (ps.executeUpdate() > 0 && p.executeUpdate() > 0) {
				status = true;
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

	public static boolean C_deleteUser(Customer user) {
		boolean status = false;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = Db_Connection.open_Connection();
			ps = con.prepareStatement("DELETE FROM customerdetails WHERE customerID=? or customerAadhar=?");
			ps.setInt(1, user.getCusId());
			ps.setInt(2, user.getAadharId());
			PreparedStatement p = con.prepareStatement("INSERT INTO customerstatus("
					+ "customerID, customerAadharID, customerStatus, customerMessage) "
					+ "values (?,?,?,?)");
			p.setInt(1, user.getCusId());
			p.setInt(2, user.getAadharId());
			p.setString(3, user.getCusStatus());
			p.setString(4, user.getCusMessage());
			if (ps.executeUpdate() > 0 && p.executeUpdate() > 0) {
				status = true;
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

	public static void getObject_Cus(Customer user,ResultSet rs) {
		try {

			user.setCusAge(rs.getInt("customerAge"));
			user.setCusName(rs.getString("customerName"));
			user.setCusAddress(rs.getString("customerAddress"));
			user.setAadharId(rs.getInt("customerAadhar"));
			user.setCusCity(rs.getString("customerCity"));
			user.setCusId(rs.getInt("customerID"));
			user.setCusState(rs.getString("customerState"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
