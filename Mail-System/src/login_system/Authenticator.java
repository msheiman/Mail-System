package login_system;

import Employee_System.EmployeeList;

public class Authenticator {

	public Authenticator(Token t, EmployeeList el) {
		if (authenticate(t, el)) {
			// pass correct token and log in employee
		}
	}

	public boolean authenticate(Token t, EmployeeList el) {
		int userCode = el.checkUsername(t.getUser());
		int passCode = el.checkPassword(t.getPword());

		if (userCode == 2 && passCode == 2) {
			return true;
		}
		return false;
	}

}
