package com.grocerystore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocerystore.pojo.Item;

import com.grocerystore.services.GroceryServiceImpl;

@RestController
public class Admin {

	@Autowired
	GroceryServiceImpl service;
	
	/*
	@GetMapping("/admin")
	@ResponseBody
	public String displayems() {

		return "service.getAllItems()";
	}
*/
	@GetMapping("/items")
	@ResponseBody
	public List<Item> displayAllItems() {

		return service.getAllItems();
	}
	
	@GetMapping("/items/{itemName}")
	public Item itemDetails(@PathVariable ("itemName") String itemName) {

		return service.getlItemDetails(itemName);

	}

	@PutMapping("/admin/items")
	public void updateItems(@PathVariable ("items") Item item) {

		service.updateItems(item);
		
	}

	@PostMapping("/admin/addItems")
	public void addNewItems(@PathVariable ("addItems") Item addItems) {
		 
		service.addNewItems(addItems);
	}

}
