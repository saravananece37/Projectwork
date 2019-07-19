package com.grocerystore.services;

public class Calculator {

	public float add(float ageDiscount,float itemDiscount,float totalAmount)
	{
		return totalAmount-ageDiscount-itemDiscount;
	}
	public float add(float itemDiscount,float price)
	{
		return price-itemDiscount;
	}
	
	
}
