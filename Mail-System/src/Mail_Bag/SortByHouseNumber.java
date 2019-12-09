package Mail_Bag;

import java.util.Comparator;

/**
* description: compares housenumbers of two different customers 
* parameters: none
* precondition: is called 
* postcondition: retuns the comparison of customer1 and customer2 
* throws: none
*/
public class SortByHouseNumber implements Comparator <Mail> {
	@Override
	public int compare(Mail o1, Mail o2) {
		return o1.getCustomer().getHouseNum() - o2.getCustomer().getHouseNum();
	}	
}
