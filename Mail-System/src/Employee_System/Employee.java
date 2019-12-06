package Employee_System;

public class Employee {

//class for storing data of the employee
// will rename to employee later
	private String firstName;
	private String lastName;
	private String email;
	private String user;
	private String password;
	
	/**
	 * description: creates constructor 
	 * parameters: String firstName, String lastName, String email, String user, String password
	 * precondition: is called 
	 * postcondition: creates constructor 
	 * throws: none
	 */
	public Employee(String firstName, String lastName, String email, String user, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.user = user;
		this.password = password;
	}
	
	/**
	 * description: creates constructor 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: creates constructor 
	 * throws: none
	 */
	public Employee() {
		this.firstName = null;
		this.lastName = null;
		this.user = null;
		this.password = null;
		this.email = null;
	}

	/**
	 * description: gets user 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: returns user 
	 * throws: none
	 */
	public String getUser() {
		return user;
	}

	/**
	 * description: sets user to this.user 
	 * parameters: String user
	 * precondition: is called 
	 * postcondition: sets user 
	 * throws: none
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * description: returns password 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: returns password 
	 * throws: none
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * description: sets password 
	 * parameters: String password
	 * precondition: is called 
	 * postcondition: sets password to this.password 
	 * throws: none
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * description: returns email 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: returns email 
	 * throws: none
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * description: sets email 
	 * parameters: String email
	 * precondition: is called 
	 * postcondition: sets email 
	 * throws: none
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * description: returns first name 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: returns first name 
	 * throws: none
	 */	
	public String getFirstName() {
		return firstName;
	}

	/**
	 * description: sets first name 
	 * parameters: String firstName
	 * precondition: is called 
	 * postcondition: sets firstName to this.firstName
	 * throws: none
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * description: gets last name 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: returns lastName 
	 * throws: none
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * description: sets last name 
	 * parameters: String lastName
	 * precondition: is called 
	 * postcondition: sets last name to this.lastName
	 * throws: none
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
}
