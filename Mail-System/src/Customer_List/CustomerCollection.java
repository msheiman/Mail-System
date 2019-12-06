package Customer_List;

import java.util.ArrayList;
import java.util.Collections;

public class CustomerCollection {
	
	ArrayList <Customer> list = new ArrayList<Customer>();
	
	/**
	 * description: creates route by sort of zipCode 
	 * parameters: ArrayList<Customer> list
	 * precondition: is called 
	 * postcondition: builds sorted route 
	 * throws: none
	 */
	public void route(ArrayList<Customer> list) {
		Collections.sort(list, new SortByZipcode());
		
	}
}
