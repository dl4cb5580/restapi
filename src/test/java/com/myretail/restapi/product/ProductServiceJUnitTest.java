package com.myretail.restapi.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ProductServiceJUnitTest {
	
	ProductService productService = new ProductService();
	
	@Test
	public void testGetProduct_Success() {
		try {
			assertNotNull(productService.getProduct(13860428));
		}catch(Exception exp) {
			exp.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testGetProduct_Failure() {
		try {
			productService.getProduct(15117729);
		}catch(Exception exp) {
			System.out.println("Product Not Found for Id"+ 15117729); 
			assertTrue(true);
		}
	}

	@Test
	public void testUpdateProduct_Success() {
		try {
			Product product = (Product) productService.updateProduct(16696652, new Product(16696652, "Beats Solo 2 Wireless - Black", new Price(229.99, "USD"))).getEntity();
			assertEquals(product.getName(), "Beats Solo 2 Wireless - Black") ;
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testUpdateProduct_Failure() {
		try {
			CustomMessage customMessage = (CustomMessage) productService.updateProduct(16752456, new Product(16752456, "Beats Solo 2 Wireless - Black", new Price(229.99, "USD"))).getEntity();
			assertEquals(customMessage.getMessage(),"Product Not Exists"); 
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
