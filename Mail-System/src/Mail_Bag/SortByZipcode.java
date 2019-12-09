package Mail_Bag;

import java.util.Comparator;

/**
* description: compares zipcode of two different customers 
* parameters: none
* precondition: is called 
* postcondition: retuns the comparison of customer1 and customer2 
* throws: none
*/
public class SortByZipcode implements Comparator <Mail> {
	@Override
	public int compare(Mail o1, Mail o2) {
		return o1.getCustomer().getZipcode() - o2.getCustomer().getZipcode();
	}	
}
