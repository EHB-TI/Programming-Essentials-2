package oefening1;

import java.util.Comparator;

public class SorterenOpNaam implements Comparator<Product> {

	public int compare(Product o1, Product o2) {
		return o1.getNaam().compareTo(o2.getNaam());
	}

}
