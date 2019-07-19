package com.grocerystore.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocerystore.database.DBConnection;
import com.grocerystore.pojo.Bill;
import com.grocerystore.pojo.Item;
import com.grocerystore.services.interfaces.BillerService;

@Service
public class BillServiceImpl implements BillerService {

	@Autowired
	DBConnection connection;

	@Override
	public float calculateBill(Bill bill) {
		// TODO Auto-generated method stub

		float totalAmount = 0f;

		try {

			Connection con = connection.getConnection();
			for (Item l : bill.getItem()) {
				PreparedStatement stmt = con.prepareStatement("select price,quantity from grocery where item=?");
				stmt.setString(1, l.getItemName());
				int currentQty = l.getQuantity();
				int existingQty = 0;
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					totalAmount += rs.getInt(1);
					existingQty = rs.getInt(2);
				}

				currentQty = existingQty - currentQty;
				stmt = con.prepareStatement("update grocery set quantity=? from grocery where item=?");
				stmt.setInt(1, currentQty);
				stmt.setString(2, l.getItemName());
				int rowCount = stmt.executeUpdate();
				if (rowCount != 1) {
					System.out.println("Error with updating quantity");
					System.exit(1);
				}
			}
		}

		// update QTY

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		TransctionServImpl transaction=new TransctionServImpl();
		
		return transaction.totalBill(totalAmount,bill);

	}
	
	
	

}
