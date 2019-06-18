package com.securepay.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class Category {
	
	public Category(String name) {
		this.name = name;
	}
	private String name;

	List<Item> items = new ArrayList<Item>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
}
