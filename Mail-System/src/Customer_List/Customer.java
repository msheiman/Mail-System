package Customer_List;

import java.util.Comparator;

import Mail_Bag.MailCollection;

public class Customer {
	private String name;
	private int houseNum;
	private String street;
	private String city;
	private String state;
	private int zipcode;
	private Mail_Bag.MailCollection mailbox;

	public Customer(String name, int houseNum, String street, String city, String state, int zipcode, MailCollection mailbox) {
		super();
		this.name = name;
		this.houseNum = houseNum;
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

	public int getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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
		return "Customer [name=" + name + ", houseNum=" + houseNum + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", zipcode=" + zipcode + ", mailbox=" + mailbox + "]";
	}

	class SortByZipcode implements Comparator <Customer>{
		@Override
		public int compare(Customer o1, Customer o2) {
			return o1.getZipcode()- o2.getZipcode();
		}	
	}
	
	class SortByHouseNumber implements Comparator <Customer>{
		@Override
		public int compare(Customer o1, Customer o2) {
			return o1.getHouseNum()- o2.getHouseNum();
		}	
	}
}
