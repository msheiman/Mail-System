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
	
	@Override
	public String toString() {
		String list = "{\n";
		CustomerNode cursor = head;
		
		while (cursor != null) {
			list += cursor.getData() + "\n";
			cursor = cursor.getLink();
		}
		
		list +="\n}";
<<<<<<< HEAD
=======
		
>>>>>>> branch 'Experimental' of https://github.com/msheiman/Mail-System.git
		return list;
	}
}
