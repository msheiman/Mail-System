package Customer_List;

public class CustomerCollection {
	private CustomerNode head;
	private CustomerNode tail;
	private int count;
	
	public CustomerCollection() {
		this.head = null;
		this.tail = null;
		this.count = 0;
	}
	
	public void addFirst(Customer customer) {
		head = new CustomerNode(customer, head);
		count++;
	}
	
	public boolean remove(Customer target) {
		CustomerNode cursor;
		CustomerNode precursor;
		for(precursor = null, cursor = head; cursor !=null; precursor = cursor, cursor = cursor.getLink()) {
			if(cursor.getData().equals(target)) {
				if(precursor == null) {
					head = head.getLink();
				}
				else {
					precursor.setLink(cursor.getLink());
				}
				count--;
				return true;
			}
		}
		return false;
	}
	
	public void add(Customer customer) {
		if (tail == null) {
			head = new CustomerNode(customer, null);
			tail = head;
		} else {
			CustomerNode newNode = new CustomerNode(customer, null);
			tail.setLink(newNode);
			tail = newNode;
		}
		count++;	
	}
	
	public int size(){
		return count;
	}
	
	public static boolean equals(String entry) {
		Object obj = entry;
		if (obj == null)
			return false;
		
		if (!(obj instanceof Customer))
			return false;
		
		Customer aCustomer = (Customer) obj;
		
		boolean isEqual = (());
		
		return isEqual;
	}
	
	@Override
	public String toString() {
		String list = "{\n";
		CustomerNode cursor = head;
		
		while (cursor != null) {
			list += cursor.getData() + "\n";
			cursor = cursor.getLink();
		}
		
		list +="\n}";
		
		return list;
	}
}
