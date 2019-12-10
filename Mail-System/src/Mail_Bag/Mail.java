package Mail_Bag;

public class Mail {
	private double weight;
	private String trackingNumber;
	private String status;
	private Customer customer;
	
	/**
	 * description: gets customer
	 * parameters: none
	 * precondition: is called
	 * postcondition: return customer
	 * throws: none
	 */	
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * description: sets setCustomer 
	 * parameters: Customer customer
	 * precondition: is called
	 * postcondition: sets customer
	 * throws: none
	 */	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * description: creates constructor 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: creates constructor 
	 * throws: none
	 */
	public Mail(double weight, String status, Customer customer) {
		this.weight = weight;
		this.trackingNumber = generateTrackingNumber();
		this.status = status;
		this.customer = customer;
	}
	
	/**
	 * description: creates constructor 
	 * parameters: double weight, String trackingNumber, String status, Customer customer
	 * precondition: is called 
	 * postcondition: creates constructor 
	 * throws: none
	 */
	public Mail(double weight, String trackingNumber, String status, Customer customer) {
		this.weight = weight;
		this.trackingNumber = trackingNumber;
		this.status = status;
		this.customer = customer;
	}

	/**
	 * description: gets status 
	 * parameters: none
	 * precondition: is called
	 * postcondition: sets status
	 * throws: none
	 */	
	public String getStatus() {
		return status;
	}
	
	/**
	 * description: sets setStatus 
	 * parameters: String status
	 * precondition: is called
	 * postcondition: sets setStatus
	 * throws: none
	 */	
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * description: gets weight 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: return weight 
	 * throws: none
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * description: set weight 
	 * parameters: double weight
	 * precondition: is called 
	 * postcondition: set weight 
	 * throws: none
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	/**
	 * description: returns tracking number 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: returns trackingNumber
	 * throws: none
	 */
	public String getTrackingNumber() {
		return trackingNumber;
	}
	
	/**
	 * description: sets trackingNumber 
	 * parameters: trackingNumber
	 * precondition: is called 
	 * postcondition: sets tracking 
	 * throws: none
	 */
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	/**
	 * Method name: generateTrackingNumber
	 * Heading: public String generateTrackingNumber()
	 * Description: creates tracking Number
	 * Parameters: none
	 * Precondition: is called
	 * Postcondition: returns tracking number
	 * Throws list: none
	 */
	public String generateTrackingNumber() {
		String trackingNumber = "";
		int number = (int) ((Math.random() * ((99999999 - 10000000) + 1)) + 10000000);
		trackingNumber = "MS" + String.valueOf(number);
		return trackingNumber.toUpperCase();
	}

	/**
	 * description: creates string of mail
	 * parameters: none
	 * precondition: is called 
	 * postcondition: creates string
	 * throws: none
	 */
	@Override
	public String toString() {
		String info = customer.toString() + String.format("%-12s%-18s%-15s",
				getWeight(), getTrackingNumber(), getStatus());
		return info;
	}
	
}	


