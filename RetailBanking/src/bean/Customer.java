package bean;

public class Customer {
	
	private int aadharId = 0;
	private int cusId = 0;
    private String cusName = null;
    
    private int cusAge = 0;
    private String cusAddress = null;
    private String cusState = null;
    
    private String cusCity = null;
    private String cusStatus = null;
    private String cusMessage = null;

    
    @Override
	public String toString() {
		return "Customer [aadharId=" + aadharId + ", cusId=" + cusId + ", cusName=" + cusName + ", cusAge=" + cusAge
				+ ", cusAddress=" + cusAddress + ", cusState=" + cusState + ", cusCity=" + cusCity + ", cusStatus="
				+ cusStatus + ", cusMessage=" + cusMessage + "]";
	}
	public int getAadharId() {
		return aadharId;
	}
	public void setAadharId(int aadharId) {
		this.aadharId = aadharId;
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public int getCusAge() {
		return cusAge;
	}
	public void setCusAge(int cusAge) {
		this.cusAge = cusAge;
	}
	public String getCusAddress() {
		return cusAddress;
	}
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}
	public String getCusState() {
		return cusState;
	}
	public void setCusState(String cusState) {
		this.cusState = cusState;
	}
	public String getCusCity() {
		return cusCity;
	}
	public void setCusCity(String cusCity) {
		this.cusCity = cusCity;
	}
	public String getCusStatus() {
		return cusStatus;
	}
	public void setCusStatus(String cusStatus) {
		this.cusStatus = cusStatus;
	}
	public String getCusMessage() {
		return cusMessage;
	}
	public void setCusMessage(String cusMessage) {
		this.cusMessage = cusMessage;
	}

}
