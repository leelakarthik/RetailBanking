package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import bean.Account;
import service.TransactionService;
import util.Db_Connection;

public class AccountDAO {

	public static boolean A_insertUser(Account user) {
		boolean status = false;
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = Db_Connection.open_Connection();
			ps = con.prepareStatement("INSERT INTO accountdetails (customerID, accountID, accountType, accountStatus, accountBalance) values (?,?,?,?,?)");
			ps.setInt(1, user.getCustomerID());
			ps.setInt(2, user.getAccountID());
			ps.setString(3, user.getAccountType());
			ps.setString(4, user.getAccountStatus());
			ps.setDouble(5, user.getAccountBalance());
			if (ps.executeUpdate() > 0) {
				status = true;
				ps.close();
				try {
					ps = con.prepareStatement("INSERT INTO accountstatus (customerID, accountID, accountType, accountStatus, message) values (?,?,?,?,?)");
					ps.setInt(1, user.getCustomerID());
					ps.setInt(2, user.getAccountID());
					ps.setString(3, user.getAccountType());
					ps.setString(4, user.getAccountStatus());
					ps.setString(5, user.getMessage());
					if (ps.executeUpdate() > 0) 
						status = true;
					else 
						status = false;
					}
					catch (SQLException e) {
						throw e;
					}
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
	public static boolean A_searchUser(Account user) {
		boolean status = false;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = Db_Connection.open_Connection();
			ps = con.prepareStatement("select * from accountdetails where accountID=? and accountType=?");
			ps.setInt(1, user.getAccountID());
			ps.setString(2, user.getAccountType());
			rs = ps.executeQuery();
			if (rs != null && rs.next()) {
				status = true;
				user.setAccountBalance(rs.getDouble("accountBalance"));
				user.setCustomerID(rs.getInt("customerID"));
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
	public static boolean A_getUser(Account user) {
		boolean status = false;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = Db_Connection.open_Connection();
			ps = con.prepareStatement("select * from accountdetails where customerID=? or accountID = ? ");
			ps.setInt(1, user.getCustomerID());
			ps.setInt(2, user.getAccountID());
			rs = ps.executeQuery();
			if (rs != null && rs.next()) {
				user.setAccountID(rs.getInt("accountID"));
				user.setCustomerID(rs.getInt("customerID"));
				user.setAccountBalance(rs.getDouble("accountBalance"));
				user.setAccountStatus(rs.getString("accountStatus"));
				user.setAccountType(rs.getString("accountType"));
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
	public static boolean A_deleteUser(Account user) {
		boolean status = false;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = Db_Connection.open_Connection();
			ps = con.prepareStatement("DELETE FROM accountdetails WHERE accountID=?");
			ps.setInt(1, user.getAccountID());
			if (ps.executeUpdate() > 0) {
				status = true;
				
				ps.close();
				try {
					ps = con.prepareStatement("INSERT INTO accountstatus ("
							+ "customerID, accountID, accountType, accountStatus, message) "
							+ "values (?,?,?,?,?)");
					ps.setInt(1, user.getCustomerID());
					ps.setInt(2, user.getAccountID());
					ps.setString(3, user.getAccountType());
					ps.setString(4, "deleted");
					ps.setString(5, "account deleted sucessfully");
					if (ps.executeUpdate() > 0) 
						status = true;
					else 
						status = false;
					}
					catch (SQLException e) {
						throw e;
					}
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
	public static boolean A_updateBal(Account user) {
		boolean status = false;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = Db_Connection.open_Connection();
			PreparedStatement p = con.prepareStatement("select accountBalance from accountdetails where accountID = ?");
			p.setInt(1, user.getAccountID());
			ResultSet r = p.executeQuery();
			double accountBalance = 0;
			if (r != null && r.next()) {
				accountBalance = r.getDouble("accountBalance");
				System.out.println(accountBalance);
			}
			ps = con.prepareStatement("update accountdetails set accountBalance = ? where accountID = ?");
			ps.setDouble(1, user.getAccountBalance());
			ps.setInt(2, user.getAccountID());
			if (ps.executeUpdate() > 0) {
				status = true;
				user.setAccountBalance(Math.abs(accountBalance-user.getAccountBalance()));
				PreparedStatement pk = con.prepareStatement("INSERT INTO transactions(accountID, transactionID, description, date, amount) VALUES (?,?,?,?,?)");
				pk.setInt(1, user.getAccountID());
				pk.setInt(2, new TransactionService().get_TransID());
				pk.setString(3, user.getMessage());
				pk.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
				pk.setDouble(5, user.getAccountBalance());
				if (pk.executeUpdate() > 0) {
					status=true;
				}
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
