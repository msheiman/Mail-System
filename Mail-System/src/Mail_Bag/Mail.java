package Mail_Bag;

public class Mail {
	private double weight;
	private int trackingNumber;
	private boolean signature;
	
	public Mail(double weight, int trackingNumber, boolean signature) {
		super();
		this.weight = weight;
		this.trackingNumber = trackingNumber;
		this.signature = signature;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(int trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public boolean isSignature() {
		return signature;
	}
	public void setSignature(boolean signature) {
		this.signature = signature;
	}
	@Override
	public String toString() {
		return "weight=" + weight + ", trackingNumber=" + trackingNumber + ", signature=" + signature + "";
	}
	
}
