package login_system;

import Employee_System.EmployeeList;

public class Authenticator {
	private Token t;
	private EmployeeList list;

	public Authenticator(Token t, EmployeeList el) {
		this.t = t;
		this.list = el;
	}

	public boolean authenticate() {
		boolean userCheck = list.checkUsername(t.getUser());
		boolean passCheck = list.checkPassword(t.getPword());

		if (userCheck == true && passCheck == true) {
			return true;
		}
		return false;
	}

}
