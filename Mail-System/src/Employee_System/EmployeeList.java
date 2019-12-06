package Employee_System;

public class EmployeeList{
	private EmployeeNode head;
	private EmployeeNode tail;
	private int listLength;
	
	public EmployeeList() {
		this.head = null;
		this.tail = null;
		this.listLength = 0;
	}

	public void add(Employee emp) {
		if(tail == null) {
			head = new EmployeeNode(emp, null);
			tail = head;
		}
		else {
			EmployeeNode newNode = new EmployeeNode(emp, null);
			tail.setLink(newNode);
			tail = newNode;
		}
		listLength++;
	}

	public void addFirst(Employee emp) {
		head = new EmployeeNode(emp, head);
		listLength++;
	}

	public boolean remove(Employee target) {
		EmployeeNode cursor;
		EmployeeNode precursor;
		
		for(precursor = null, cursor = head; cursor != null;
				precursor = cursor, cursor = cursor.getLink()) {
			
			if (cursor.getData().equals(target)) {
				if (precursor == null) {
					head = head.getLink();
				} else {
					precursor.setLink(cursor.getLink());
				}
				listLength--;
				return true;
			}
		}
		return false;
	}

	public boolean checkUsername(String username) {
		if (username == null) {
			throw new IllegalArgumentException("Illegal Username\n");
		}
		
		EmployeeNode cursor = head;
		boolean flag = false;
		
		if (cursor == null)
			throw new NullPointerException ("Employee List is empty.");
		else {
			// other wise, compare the id of data of linked list and the argument
			// from the head to the node before the tail
			while (cursor != null) {
				if (cursor.getData().getUser().equals(username)) {
					// if the target is found, change the flag to true
					// and break the loop
					flag = true;
					break;
				}
				// move to next link if current node is not target node
				cursor = cursor.getLink();
			}
		}
		return flag;
	}

	public boolean checkPassword(String password) {
		if (password == null || password.trim() ==  "") {
			throw new IllegalArgumentException("Illegal Username\n");
		}
		
		EmployeeNode cursor = head;
		boolean flag = false;
		
		if (cursor == null)
			throw new NullPointerException ("Employee List is empty.");
		else {
			// other wise, compare the id of data of linked list and the argument
			// from the head to the node before the tail
			while (cursor != null) {
				if (cursor.getData().getPassword().equals(password)) {
					// if the target is found, change the flag to true
					// and break the loop
					flag = true;
					break;
				}
				// move to next link if current node is not target node
				cursor = cursor.getLink();
			}
		}
		return flag;
	}

	public int getListLength() {
		return listLength;
	}

	public void setListLength(int listLength) {
		this.listLength = listLength;
	}

}
