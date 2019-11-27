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

	/**
	 * description: creates constructor 
	 * parameters:String name, int houseNum, String street, String city, String state, int zipcode, MailCollection mailbox
	 * precondition: is called 
	 * postcondition: creates constructor 
	 * throws: none
	 */
	public Customer(String name, int houseNum, String street, String city, String state, int zipcode, MailCollection mailbox) {
		super();
		this.name = name;
		this.houseNum = houseNum;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.mailbox = mailbox;
	}

	/**
	 * description: returns name 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: returns name 
	 * throws: none
	 */
	public String getName() {
		return name;
	}

	/**
	 * description: set name 
	 * parameters: String name
	 * precondition: is called 
	 * postcondition: set name 
	 * throws: none
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * description: returns houseNum 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: returns houseNum 
	 * throws: none
	 */
	public int getHouseNum() {
		return houseNum;
	}

	/**
	 * description: sets houseNum 
	 * parameters: int houseNum
	 * precondition: is called
	 * postcondition: sets houseNum
	 * throws: none
	 */
	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}

	/**
	 * description: return street 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: returns street 
	 * throws: none
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * description: set street 
	 * parameters: String
	 * precondition: is called 
	 * postcondition: set street 
	 * throws: none
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * description: returns city 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: returns city 
	 * throws: none
	 */
	public String getCity() {
		return city;
	}

	/**
	 * description: set city 
	 * parameters: String city
	 * precondition: is called 
	 * postcondition: sets city 
	 * throws: none
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * description: returns state 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: returns state 
	 * throws: none
	 */
	public String getState() {
		return state;
	}

	/**
	 * description: sets state 
	 * parameters: String state
	 * precondition: is called 
	 * postcondition: sets state
	 * throws: none
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * description: returns zipcode 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: returns zipcode 
	 * throws: none
	 */
	public int getZipcode() {
		return zipcode;
	}

	/**
	 * description: sets zipcode 
	 * parameters: int zipcode
	 * precondition: is called 
	 * postcondition: sets zipcode 
	 * throws: none
	 */
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * description: creates mailbox
	 * parameters: none
	 * precondition: is called 
	 * postcondition: creates mailbox 
	 * throws: none
	 */
	public MailCollection getMailbox() {
		return mailbox;
	}

	/**
	 * description: sets mailbox 
	 * parameters: MailCollection mailbox
	 * precondition: is called 
	 * postcondition: sets mailbox 
	 * throws: none
	 */
	public void setMailbox(MailCollection mailbox) {
		this.mailbox = mailbox;
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
		return name + "\n" + houseNum + street + ", " + city + ", " + state + ", " + zipcode;
	}

	/**
	 * description: sorts customer by zipcode 
	 * parameters: Customer o1, Customer o2
	 * precondition: is called 
	 * postcondition: returns compare 
	 * throws: none
	 */
	class SortByZipcode implements Comparator <Customer>{
		@Override
		public int compare(Customer o1, Customer o2) {
			return o1.getZipcode()- o2.getZipcode();
		}	
	}
	
	/**
	 * description: sorts customer by housenum 
	 * parameters: Customer o1, Customer o2
	 * precondition: is called 
	 * postcondition: returns compare 
	 * throws: none
	 */
	class SortByHouseNumber implements Comparator <Customer>{
		@Override
		public int compare(Customer o1, Customer o2) {
			return o1.getHouseNum()- o2.getHouseNum();
		}	
	}
}
