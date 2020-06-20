package service;

import bean.Employee;
import dao.userDAO;

public class userService {
    public boolean EinsertUserService(Employee u) {
        return userDAO.insertUser(u);
    }
    public boolean EgetUserService(Employee u) {
        return userDAO.getUser(u);
    }	
}
