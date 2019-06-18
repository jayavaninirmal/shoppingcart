package com.securepay.shoppingcart;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * CategoryFactory creates given number of categories with items for each category.
 * The items are sorted in such a way that least total valued and best rating item are appeared first.
 * 
 * 
 * @author jayavaniswaminathan
 *
 */
public class CategoryFactory {

	public static final int ITEMS_COUNT = 10;
	public Category createCategory(int categoryNumber) {
		Category category =  new Category("Category" + categoryNumber);
		List<Item> items = new ArrayList<Item>();
		for(int i = 1; i<= ITEMS_COUNT ; i++) {
			items.add((new ItemFactory()).createItem(i));
		}
		items.sort(Comparator.comparingDouble(Item::getTotalCost)
				.thenComparing(Comparator.comparing(Item::getRating).reversed()));
		category.setItems(items);
		return category;
	}
}
