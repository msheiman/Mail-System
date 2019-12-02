package Employee_System;

public class Employee {

//class for storing data of the employee
// will rename to employee later
	private String firstName;
	private String lastName;
	private String email;
	private String user;
	private String password;
	


	public Employee(String firstName, String lastName, String email, String user, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.user = user;
		this.password = password;
	}

	public Employee() {
		this.firstName = null;
		this.lastName = null;
		this.user = null;
		this.password = null;
		this.email = null;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
}