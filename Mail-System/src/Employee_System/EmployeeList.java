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
		if (emp.equals(null))
			throw new IllegalArgumentException("Cannot add to the beginning of list because parameter is invalid.\n");
		head = new EmployeeNode(emp, head);
		listLength++;
	}

	public boolean remove(Employee target) {
		if (target.equals(null))
			throw new IllegalArgumentException("Cannot remove the employee from the list because parameter is invalid.\n");
		
		// create 2 nodes to keep track of a node and a node before it
		EmployeeNode cursor;
		EmployeeNode precursor;
		
		// cursor runs from head to a node that's not null, precursor runs from null
		// update: cursor goes to next node, precursor goes to cursor's place
		for(precursor = null, cursor = head; cursor != null;
				precursor = cursor, cursor = cursor.getLink()) {
			
			// if data of the node that cursor currently points equals to the target
			// check of precursor is null
			if (cursor.getData().equals(target)) {
				
				// if it's null, it means target is found at the head of list
				// head will become the next node
				// found target will be removed
				if (precursor == null) {
					head = head.getLink();
				} 
				// otherwise, move both cursor and precursor to next nodes
				else {
					precursor.setLink(cursor.getLink());
				}
				
				// decrease the number of links in list
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
	
	/**
	 * Method name: countSize
	 * Heading: public int countSize() 
	 * Description: to count the number of element in the linked list
	 * Parameters: none
	 * Precondition: the temporary counter is not null
	 * Postcondition: return the number of elements in linked list
	 * Throws list: N/A
	 */
	public int countSize() { 
		
		// create a node named temp pointing at head of list
		EmployeeNode temp = head; 
		// create a counter and initialize 0 to it
		listLength = 0; 
		// temp runs from head to the end
	    while (temp != null) { 
	    	//counter upgrades by 1 each time
	    	listLength++; 
	    	//go to next node
	    	temp = temp.getLink(); 
	    } 
	    return listLength; 
	}

}
