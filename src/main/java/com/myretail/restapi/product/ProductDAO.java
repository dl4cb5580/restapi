package com.myretail.restapi.product;

import java.util.HashMap;
import java.util.Map;

public class ProductDAO {
	
	private static Map<Integer, Price> priceMap = new HashMap<Integer, Price>();
	
	//This is my NoSQL data store for product price information. 
	static {
		priceMap.put(13860428, new Price(13.49, "USD"));
		priceMap.put(13860429, new Price(08.99, "USD"));
		priceMap.put(16696652, new Price(219.99, "USD"));
		priceMap.put(16696651, new Price(219.99, "USD"));
	}
	
	public Price getProductPrice(int productId) {
		return priceMap.get(productId);
	}
	
	public boolean updateProductPrice(int productId, Price price) {
		if(priceMap.containsKey(productId)) {
			priceMap.put(productId, price); //This will update the price object in the data store
			return true;
		} else {
			return false;
		}
	}
	
}
