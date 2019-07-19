package com.grocerystore.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Service;


@Service
public class DBConnection {

	Connection connection=null;
	public Connection getConnection() throws SQLException
	{
		
		
		try {
			   connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Grocery", "grocery", "grocery");
			}
			catch(Exception ex) {
			   System.out.println("unable to load driver class");
			   
			}
		return connection;
	}
	
	
	public void close()
	{
		try {
			if(connection!=null)
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
