package Mail_Bag;

public class Customer {
	private String firstName;
	private String lastName;
	private int houseNum;
	private String street;
	private String city;
	private String state;
	private int zipcode;

	/**
	 * description: creates constructor 
	 * parameters:String name, int houseNum, String street, String city, String state, int zipcode, MailCollection mailbox
	 * precondition: is called 
	 * postcondition: creates constructor 
	 * throws: none
	 */
	public Customer(String firstName, String lastName, int houseNum, String street, String city, String state, int zipcode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.houseNum = houseNum;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;

	}
	
	public Customer() {
		this.firstName = null;
		this.lastName = null;
		this.houseNum = 0;
		this.street = null;
		this.city = null;
		this.state = null;
		this.zipcode = 0;

	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * description: creates string 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: creates string 
	 * throws: none
	 */
	@Override
	public String toString() {
		String info = String.format("%-20s%-25s%-25s%-6s%-10s",
		firstName + " " + lastName, houseNum + " " + street, city, state, zipcode);
		return info;
	}
}

