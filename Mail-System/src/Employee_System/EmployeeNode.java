package Employee_System;

public class EmployeeNode {
	private Employee data;
	private EmployeeNode link;
	
	public EmployeeNode(Employee data, EmployeeNode link) {
		this.data = data;
		this.link = link;
	}

	public Employee getData() {
		return data;
	}

	public void setData(Employee data) {
		this.data = data;
	}

	public EmployeeNode getLink() {
		return link;
	}

	public void setLink(EmployeeNode link) {
		this.link = link;
	}
	
}
