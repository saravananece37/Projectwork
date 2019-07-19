package com.grocerystore.Main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xmlunit.input.WhitespaceNormalizedSource;

import com.grocerystore.pojo.Bill;
import com.grocerystore.pojo.Item;
import com.grocerystore.services.BillServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainApplicationTests {

	@Test
	public void contextLoads() {
	
	
	}

	@Mock
	BillServiceImpl billServiceImpl;
	 
	@Test
	public void test()
	{
		Bill bill=new Bill();
		bill.setAgeOfCustomer(89);
		List<Item> l=new ArrayList();
		Item i=new Item();
		i.setItemName("Chocalte");
		i.setPrice(40);
		i.setQuantity(100);
		
		l.add(i);
		
		bill.setItem(l);
		when(billServiceImpl.calculateBill(bill)).thenReturn(3900.0f);
		assertEquals(billServiceImpl.calculateBill(bill), 3900.0f);
		
		
	}
	
	
	
}
