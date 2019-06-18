package com.securepay.shoppingcart;

import java.util.Comparator;

public class CategoryComparator implements Comparator<Category> {

	@Override
	public int compare(Category c1, Category c2) {
		Item i1 = c1.getItems().get(0);
		Item i2 = c2.getItems().get(0);
		
		if (i1.getTotalCost() < i2.getTotalCost()) return -1;
        if (i1.getTotalCost() > i2.getTotalCost()) return 1;
        return 0;
	}

}
