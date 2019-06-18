package com.securepay.shoppingcart;


/**
 * 
 * ItemFactory creates Item object. 
 * Each item is randomly assigned with:
 *	A price of between $1 to $20
 *	A shipping cost of between $2 to $5
 *	A rating of between 1 to 5 (a bigger value indicates a better rating)
 * 
 * @author jayavaniswaminathan
 *
 */
public class ItemFactory {
	public Item createItem(int itemNumber) {
		double price = RandomNumberGenerator.getRandomNumber(1.0, 20.0, 2); 
		double shippingCost = RandomNumberGenerator.getRandomNumber(2.0, 5.0, 2);
		double rating = RandomNumberGenerator.getRandomNumber(1.0,5.0,1);
		Item item = new Item("Item" + itemNumber);
		item.setPrice(price);
		item.setShippingCost(shippingCost);
		item.setRating(rating);
		item.setTotalCost(RandomNumberGenerator.formatDouble(price + shippingCost, 2));
		return item;
	}
}
