package com.grocerystore.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocerystore.database.DBConnection;
import com.grocerystore.pojo.Item;
import com.grocerystore.services.interfaces.GroceryService;

@Service
public class GroceryServiceImpl implements GroceryService {

	@Autowired
	DBConnection connection;

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		List<Item> list = new ArrayList<>();

		try {
			PreparedStatement stmt = connection.getConnection().prepareStatement("select * from grocery");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Item items = new Item();
				items.setItemName(rs.getString(1));
				items.setQuantity(rs.getInt(2));
				items.setPrice(rs.getInt(3));
				list.add(items);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
		connection.close();
		}
		return list;
	}

	@Override
	public Item getlItemDetails(String itemName) {
		Item items = new Item();
		try {
			PreparedStatement stmt = connection.getConnection().prepareStatement("select * from registerA where item=?");
			stmt.setString(1, itemName);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				items.setItemName(rs.getString(1));
				items.setQuantity(rs.getInt(2));
				items.setPrice(rs.getInt(3));
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally
		{
		connection.close();
		}
		return items;
	}

	@Override
	public void updateItems(Item item) {

		try {
			String itemName=item.getItemName();
			PreparedStatement stmt = connection.getConnection().prepareStatement("select quantity from grocery where item=?");
			stmt.setString(1, itemName);
			int existingQty=0;
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				existingQty=rs.getInt(1);
				}
			
			PreparedStatement stmt1 = connection.getConnection().prepareStatement("update quantity from grocery where item=? and quantity=?");
			stmt1.setString(1, itemName);
			stmt1.setInt(2, existingQty+item.getQuantity());
			int rowCount=stmt1.executeUpdate();
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
	public void addNewItems(Item item) {
		try {
			PreparedStatement stmt = connection.getConnection().
			prepareStatement("insert into grocery values(?,?,?)");
			stmt.setString(1, item.getItemName());
			stmt.setInt(2, item.getQuantity());
			stmt.setInt(3, item.getPrice());
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

}
