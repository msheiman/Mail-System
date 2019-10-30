package Customer_List;

public class CustomerNode {
	
	private Customer data;
	private CustomerNode link;
	
	public CustomerNode(Customer data, CustomerNode link) {
		this.data = data;
		this.link = link;
	}

	public Customer getData() {
		return data;
	}

	public void setData(Customer data) {
		this.data = data;
	}

	public CustomerNode getLink() {
		return link;
	}

	public void setLink(CustomerNode link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "CustomerNode [data=" + data + ", link=" + link + "]";
	}
	
	
	

}
