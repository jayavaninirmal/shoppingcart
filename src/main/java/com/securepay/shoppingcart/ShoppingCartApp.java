package com.securepay.shoppingcart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * ShoppingCartApp creates 20 categories with 10 items each. The items are sorted in such a way that least total
 *  valued and best rating item are sorted first.
 * The categories list is then sorted in such a way that the category with least total valued item appears first.
 * The result is calculated by adding each category's item until the total cost is below the budget limit of $50.
 * 
 * @author jayavaniswaminathan
 *
 */
public class ShoppingCartApp {
	
	public static final double BUDGET_LIMIT = 50.0;
	
	public static final int CATEGORIES_COUNT = 20;
	
	static List<Category> categoryList = new ArrayList<Category>();
	
	static CategoryFactory factory = new CategoryFactory();
	
	static Map<String, String> resultMap = new HashMap<String, String>();
	
	static double totalCost = 0.0;
	
	static double totalRating = 0.0;
	
	public static void main(String arg[]) {
		
		createCategories(CATEGORIES_COUNT); 
		
		// Sort the categories in such a way the category with least total valued item appear first.
		Collections.sort(categoryList, new CategoryComparator());
		
		calculateResult(categoryList);
		
		displayResults(resultMap, totalCost, totalRating);
	}
	
	public static List<Category> createCategories(int categoriesCount) {
		for(int i=1; i<=categoriesCount; i++) {
			categoryList.add(factory.createCategory(i));
		}
		return categoryList;
	}
	
	public static double calculateResult(List<Category> categoryList) {
		for(Category category : categoryList) {
			if(category == null || category.getItems() == null || category.getItems().get(0) == null) {
				return 0.0;
			}
			// The first item in the category is the cheap and best rated item. Hence, that item is taken for calculation.
			Item item = category.getItems().get(0);
			if((totalCost + item.getTotalCost()) <= BUDGET_LIMIT) {
				resultMap.put(category.getName(), item.getName()); 
				totalCost += item.getTotalCost();
				totalRating += item.getRating();
			} else {
				break;
			}
		}
		return totalCost;
	}
	
	public static void displayResults(Map<String, String> resultMap, double totalCost, double totalRating) {
		System.out.println("Picked items:\n-------------");
		resultMap.forEach((k,v)->System.out.println(k + ":" + v));
		System.out.println("\nTotal cost of items picked: " + RandomNumberGenerator.formatDouble(totalCost, 2));
		System.out.println("\nTotal ratings of items picked: " + RandomNumberGenerator.formatDouble(totalRating, 2));
	}
}
