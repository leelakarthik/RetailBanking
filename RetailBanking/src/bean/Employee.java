package bean;

public class Employee {
    private String username = null;
    private String password = null;
    private String name = null;
    private String age = null;
    private String role = null;
    public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [username=" + username + ", password=" + password + ", name=" + name + ", age=" + age
				+ ", role=" + " role]";
	}
	
}
