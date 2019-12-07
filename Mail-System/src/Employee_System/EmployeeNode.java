package Employee_System;

public class EmployeeNode {
	private Employee data;
	private EmployeeNode link;
	
	/**
	 * Method name: EmployeeNode()
	 * Heading: public EmployeeNode(Employee data, Employee link) 
	 * Description: to create the constructor of EmployeeNode
	 * Parameters: Employee data, EmployeeNode link
	 * Precondition: the contructor is called
	 * Postcondition: creates the constructor
	 * Throws list: N/A
	 */	
	public EmployeeNode(Employee data, EmployeeNode link) {
		this.data = data;
		this.link = link;
	}

	/**
	 * Method name: getData()
	 * Heading: public Employee getData() 
	 * Description: returns data
	 * Parameters: none
	 * Precondition: is called
	 * Postcondition: returns data
	 * Throws list: N/A
	 */
	public Employee getData() {
		return data;
	}

	/**
	 * Method name: setData()
	 * Heading: public void setData()
	 * Description: to set data
	 * Parameters: Employee data
	 * Precondition:  is called
	 * Postcondition: sets Employee data to this.data
	 * Throws list: N/A
	 */
	public void setData(Employee data) {
		this.data = data;
	}

	/**
	 * Method name: getLink()
	 * Heading: public EmployeeNode getLink() 
	 * Description: returns link
	 * Parameters: none
	 * Precondition: is called
	 * Postcondition: returns link
	 * Throws list: N/A
	 */
	public EmployeeNode getLink() {
		return link;
	}


	/**
	 * Method name: setLink()
	 * Heading: public void setLink()
	 * Description: to set Link
	 * Parameters: EmployeeNode link
	 * Precondition:  is called
	 * Postcondition: sets EmployeeNode link to this.link
	 * Throws list: N/A
	 */	
	public void setLink(EmployeeNode link) {
		this.link = link;
	}
	
}
