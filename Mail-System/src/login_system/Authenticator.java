package login_system;

import Employee_System.EmployeeList;

public class Authenticator {
	private Token t;
	private EmployeeList list;

	/**
	 * Method name: Authenticator()
	 * Heading: public Authenticator(Token t, EmployeeList el) 
	 * Description: to create the constructor of Authenticator
	 * Parameters: Token t, EmployeeList el
	 * Precondition: the constructor is called
	 * Postcondition: creates the constructor
	 * Throws list: N/A
	 */
	public Authenticator(Token t, EmployeeList el) {
		this.t = t;
		this.list = el;
	}
	
	/**
	 * Method name: authenticate()
	 * Heading: public boolean authenticate() 
	 * Description: to checks in userCheck and passCheck is true
	 * Parameters: none
	 * Precondition: if userCheck and passCheck both are true
	 * Postcondition: returns true or false
	 * Throws list: N/A
	 */
	public boolean authenticate() {
		
		//check both username and password
		boolean check = list.check(t.getUser(), t.getPword());
		
		//if check is true, return true
		//otherwise, return false
		if (check == true) {
			return true;
		}
		return false;
	}
}
