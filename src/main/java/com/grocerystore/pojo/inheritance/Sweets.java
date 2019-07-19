package com.grocerystore.pojo.inheritance;

import com.grocerystore.pojo.Item;

public class Sweets extends Item {

	private String calories;

	public String getRegisterName() {
		return calories;
	}

	public void setRegisterName(String calories) {
		this.calories = calories;
	}
	

}
