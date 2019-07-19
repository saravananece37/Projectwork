package com.grocerystore.services.interfaces;

import com.grocerystore.pojo.Bill;

public interface TransactionService {

	
	public void addDBEntry(double transactionID,float totalBill,int ageOfCustomer);
	public float totalBill(float totalAmount,Bill bill);
}
