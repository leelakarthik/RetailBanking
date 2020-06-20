package bean;

public class Account {
	private int customerID;
	private int accountID;
	private String accountType;
	private String accountStatus;
	private double accountBalance;
	private String message;
	
	public int getCustomerID() {
		return customerID;
	}
	public int getAccountID() {
		return accountID;
	}
	public String getAccountType() {
		return accountType;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public String getMessage() {
		return message;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Account [customerID=" + customerID + ", accountID=" + accountID + ", accountType=" + accountType
				+ ", accountStatus=" + accountStatus + ", accountBalance=" + accountBalance + ", message=" + message
				+ "]";
	}
	
}
