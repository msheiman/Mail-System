package Mail_Bag;

import java.util.Random;

public class Mail {
	private double weight;
	private String trackingNumber;
	private boolean signature;
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * description: creates constructor 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: creates constructor 
	 * throws: none
	 */
	public Mail(double weight, boolean signature) {
		super();
		this.weight = weight;
		this.trackingNumber = generateTrackingNumber();
		this.signature = signature;
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
	 * description: returns signature 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: sets signature 
	 * throws: none
	 */
	public boolean isSignature() {
		return signature;
	}
	
	/**
	 * description: sets boolean signature 
	 * parameters: none
	 * precondition: is called 
	 * postcondition: sets boolean signature
	 * throws: none
	 */
	public void setSignature(boolean signature) {
		this.signature = signature;
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
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    	Random rnd = new Random();
		char char1 = alphabet.charAt(rnd.nextInt(alphabet.length()));
	   	char char2 = alphabet.charAt(rnd.nextInt(alphabet.length()));
		int number = (int) ((Math.random() * ((99999999 - 10000000) + 1)) + 10000000);
		trackingNumber = char1 + char2 + String.valueOf(number);
		return trackingNumber;
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
		String info = "";
		info = "%-";
		return info;
	}
	
}
