package com.grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.grocerystore.pojo.Bill;
import com.grocerystore.pojo.Item;
import com.grocerystore.services.BillServiceImpl;

@RestController
public class Customer {

	@Autowired
	BillServiceImpl billServiceImpl;
	
	@GetMapping("/customer/bill/{items}")
	public float addBill(@PathVariable ("items") Bill	items)
	{
		 return billServiceImpl.calculateBill(items);
	}
}
