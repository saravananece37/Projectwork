package com.grocerystore.pojo;

import java.util.List;

public class Bill {

	private List<Item> item;
	private int ageOfCustomer;
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	public int getAgeOfCustomer() {
		return ageOfCustomer;
	}
	public void setAgeOfCustomer(int ageOfCustomer) {
		this.ageOfCustomer = ageOfCustomer;
	}
	
	
}
