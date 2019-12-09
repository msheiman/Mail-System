package Mail_Bag;

import java.util.Comparator;

public class SortByZipcode implements Comparator <Mail> {
	@Override
	public int compare(Mail o1, Mail o2) {
		return o1.getCustomer().getZipcode() - o2.getCustomer().getZipcode();
	}	
}
