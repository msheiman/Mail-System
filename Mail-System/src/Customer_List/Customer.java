package Customer_List;

import Mail_Bag.MailCollection;

public class Customer {
	private String name;
	private String address;
	private String city;
	private String state;
	private int zipcode;
	private Mail_Bag.MailCollection mailbox;

	public Customer(String name, String address, String city, String state, int zipcode, MailCollection mailbox) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.mailbox = mailbox;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public MailCollection getMailbox() {
		return mailbox;
	}

	public void setMailbox(MailCollection mailbox) {
		this.mailbox = mailbox;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + "number of letters: " + mailbox.length() + "]";
	}

}
