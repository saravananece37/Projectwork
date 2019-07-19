package com.grocerystore.services.interfaces;

import java.util.List;

import com.grocerystore.pojo.Item;

public interface GroceryService {

	public List<Item> getAllItems();
	public Item getlItemDetails(String itemName);
	public void updateItems(Item item);
	public void addNewItems(Item item);

	
	
	
}
