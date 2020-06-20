package service;

import bean.Customer;
import dao.CustomerDAO;
import util.Gen_customerID;

public class CustomerService {
	public boolean C_insertUserService(Customer u) {
        return CustomerDAO.C_insertUser(u);
    }
    public boolean C_getUserService(Customer u) {
        return CustomerDAO.C_searchUser(u);
    }
    public boolean C_updateUserService(Customer u) {
        return CustomerDAO.C_updateUser(u);
    }
    public boolean C_deleteUserService(Customer u) {
        return CustomerDAO.C_deleteUser(u);
    }
    public int get_CusID() {
    	return Gen_customerID.Gen_ID();
    }
}
