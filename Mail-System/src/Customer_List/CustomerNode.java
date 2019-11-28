package Customer_List;

public class CustomerNode {
	
	private Customer data;
	private CustomerNode link;
	
	/**
	 * description: creates constructor 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: creates constructor 
	 * throws: none
	 */
	public CustomerNode(Customer data, CustomerNode link) {
		this.data = data;
		this.link = link;
	}

	/**
	 * description: returns data
	 * parameters: none
	 * precondition: is called 
	 * postcondition: returns data
	 * throws: none
	 */
	public Customer getData() {
		return data;
	}

	/**
	 * description: sets data
	 * parameters: Customer data
	 * precondition: is called 
	 * postcondition: creates data 
	 * throws: none
	 */
	public void setData(Customer data) {
		this.data = data;
	}

	/**
	 * description: returns link 
	 * parameters: none
	 * precondition: is called
	 * postcondition: returns link 
	 * throws: none
	 */
	public CustomerNode getLink() {
		return link;
	}

	/**
	 * description: set link 
	 * parameters: CustomerNode link
	 * precondition: is called 
	 * postcondition: set link 
	 * throws: none
	 */
	public void setLink(CustomerNode link) {
		this.link = link;
	}

	/**
	 * description: creates string 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: creates string 
	 * throws: none
	 */
	@Override
	public String toString() {
		return "CustomerNode [data=" + data + ", link=" + link + "]";
	}
	
	
	

}
