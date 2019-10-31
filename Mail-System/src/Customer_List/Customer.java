package Customer_List;

import Mail_Bag.MailCollection;

public class Customer {
	private String name;
	private String address;
	private Mail_Bag.MailCollection mailbox;

	public Customer(String name, String address, MailCollection mailbox) {
		super();
		this.name = name;
		this.address = address;
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
