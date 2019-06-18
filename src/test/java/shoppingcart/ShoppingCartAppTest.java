package shoppingcart;


import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.securepay.shoppingcart.Category;
import com.securepay.shoppingcart.CategoryComparator;
import com.securepay.shoppingcart.Item;
import com.securepay.shoppingcart.ItemFactory;
import com.securepay.shoppingcart.ShoppingCartApp;



public class ShoppingCartAppTest {
	
	@Test
	public void createCategoriesTest() {
		List<Category> categoriesList = ShoppingCartApp.createCategories(5);
		assertEquals(5, categoriesList.size());
	}
	
	@Test
	public void createItemsTest() {
		Item item = new ItemFactory().createItem(1);
		assertEquals("Item1", item.getName());
		assert(item.getPrice() >= 1.0 && item.getPrice() <= 20.0);
		assert(item.getShippingCost() >= 2.0 && item.getShippingCost() <= 5.0);
		assert(item.getRating() >= 1.0 && item.getRating() <= 5.0);
		assert(item.getTotalCost() > 3.0 && item.getTotalCost() <= 25.0);
	}
	
	@Test
	public void pickItemsTest() {
		List<Category> categoriesList = ShoppingCartApp.createCategories(5);
		Collections.sort(categoriesList, new CategoryComparator());
		double totalCost = ShoppingCartApp.calculateResult(categoriesList);
		assert(totalCost <= 50.0);
	}
}
