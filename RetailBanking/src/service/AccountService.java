package service;

import bean.Account;
import dao.AccountDAO;
import util.Gen_accountID;

public class AccountService {
	public boolean A_insertUserService(Account user) {
		return AccountDAO.A_insertUser(user);
	}
	public boolean A_SearchCustomer_Service(Account user) {
		return AccountDAO.A_searchUser(user);
	}
	public boolean A_GetCustomer_Service(Account user) {
		return AccountDAO.A_getUser(user);
	}
	public boolean A_deleteCustomer_Service(Account user) {
		return AccountDAO.A_deleteUser(user);
	}
	public boolean A_updateBalance(Account user) {
		return AccountDAO.A_updateBal(user);
	}
    public int get_AccID() {
    	return Gen_accountID.Gen_ID();
    }
}
