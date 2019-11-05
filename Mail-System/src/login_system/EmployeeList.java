package login_system;

//employee list
// will rename to employee list later 

public class EmployeeList {
	private UserNode head;
	private UserNode tail;
	private int listLength;

	public void addTail(Employee element) {
		tail = tail.setLink(new UserNode(element, null));
		listLength++;
	}

	public void addHead(Employee element) {
		head = new UserNode(element, head);
		listLength++;
	}

	public boolean remove(Employee target) {
		UserNode c;
		UserNode p;
		for (c = head, p = null; c.getLink() != null; p = c, c.setLink(c.getLink())) {
			if (c.getUser() == target) {
				p.setLink(c.getLink());
				listLength--;
				return true;
			}
		}

		return false;
	}

	public int checkUsername(String uName) {
		UserNode c;
		UserNode p;
		Employee e;
		for (c = head, p = null; c.getLink() != null; p = c, c.setLink(c.getLink())) {
			e = c.getUser();
			if (e.getUser() == uName) {
				return 2;
			}
		}
		return 1;
	}

	public int checkPassword(String pw) {
		UserNode c;
		UserNode p;
		Employee e;
		for (c = head, p = null; c.getLink() != null; p = c, c.setLink(c.getLink())) {
			e = c.getUser();
			if (e.getPassword() == pw) {
				return 2;
			}
		}
		return 1;
	}

}
