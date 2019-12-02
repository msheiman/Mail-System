package login_system;

import Employee_System.Employee;

//node for the user linked list
//will rename to employee node later
public class UserNode {
	private Employee user;
	private UserNode link;

	public UserNode(Employee user, UserNode link) {
		this.user = user;
		this.link = link;
	}

	public Employee getUser() {
		return user;
	}

	public void setUser(Employee user) {
		this.user = user;
	}

	public UserNode getLink() {
		return link;
	}

	public UserNode setLink(UserNode link) {
		this.link = link;
		return link;
	}

}
