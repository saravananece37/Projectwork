package com.grocerystore.services;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.grocerystore.database.DBConnection;
import com.grocerystore.pojo.Bill;
import com.grocerystore.services.interfaces.TransactionService;

public class TransctionServImpl implements TransactionService{

	@Autowired
	DBConnection connection;

	
	@Override
	public void addDBEntry(double transactionID,float totalBill,int ageOfCustomer) {

		try {
			PreparedStatement stmt = connection.getConnection().
					prepareStatement("insert into transaction values(?,?,?)");
			stmt.setDouble(1,transactionID);
			stmt.setFloat(2, totalBill);
			stmt.setInt(3, ageOfCustomer);
			int rowCount= stmt.executeUpdate();
			if(rowCount==1)
			{
				System.out.println("updated");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		finally
		{
		connection.close();
		}

		
		
	}

	@Override
	public float totalBill(float totalAmount, Bill bill) {
		// TODO Auto-generated method stub
		
		Calculator calc=new Calculator();
		// Overloading test
		if (totalAmount > 1000 && bill.getAgeOfCustomer() >= 60 && bill.getItem().get(0).getItemName().equalsIgnoreCase("Sugar"))
		 return calc.add(100.0f, 100.0f, totalAmount);
			
		else if (bill.getItem().get(0).getItemName().equalsIgnoreCase("Sugar") && totalAmount >= 1000)
			return calc.add(100.0f, totalAmount);
		
		
		else if (bill.getAgeOfCustomer()>=60 && totalAmount >= 1000)
			return calc.add(100.0f, totalAmount);
		
		double transactionID=Math.random();
				
		addDBEntry(transactionID,totalAmount,bill.getAgeOfCustomer());
		
		return totalAmount;
	}

}
