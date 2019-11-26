package Customer_List;

import java.util.ArrayList;
import java.util.Collections;

public class CustomerCollection {
	
	ArrayList <Customer> list = new ArrayList<Customer>();
	
	public void route(ArrayList<Customer> list) {
		Collections.sort(list, new SortByZipcode());
		
	}
}
