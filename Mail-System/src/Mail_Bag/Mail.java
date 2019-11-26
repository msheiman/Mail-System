package Mail_Bag;

import java.util.Random;

public class Mail {
	private double weight;
	private String trackingNumber;
	private boolean signature;
	
	public Mail(double weight, boolean signature) {
		super();
		this.weight = weight;
		this.trackingNumber = generateTrackingNumber();
		this.signature = signature;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String  trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public boolean isSignature() {
		return signature;
	}
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
		String tracking = "";
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    Random rnd = new Random();
	    char char1 = alphabet.charAt(rnd.nextInt(alphabet.length()));
	    char char2 = alphabet.charAt(rnd.nextInt(alphabet.length()));
		int number = (int) ((Math.random() * ((99999999 - 10000000) + 1)) + 10000000);
		tracking = char1 + char2 + String.valueOf(number);
		return tracking;
	}
	@Override
	public String toString() {
		return "weight=" + weight + ", trackingNumber=" + trackingNumber + ", signature=" + signature + "";
	}
	
}
