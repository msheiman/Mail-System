package Mail_Bag;

import java.util.Comparator;

public class SortByHouseNumber implements Comparator <Mail> {
	@Override
	public int compare(Mail o1, Mail o2) {
		return o1.getCustomer().getHouseNum() - o2.getCustomer().getHouseNum();
	}	
}
