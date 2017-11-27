package com.myretail.restapi.product;

import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ProductUtil {

	private String redSkyURL = "http://redsky.target.com/v2/pdp/tcin/productId?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
	
	public String getProductName(int productId) throws Exception { 
		String productName = null;
		
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(redSkyURL.replaceFirst("productId", String.valueOf(productId)));
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			String output = response.getEntity(String.class);
			JSONObject json = new JSONObject(output);
			productName = json.getJSONObject("product").getJSONObject("item").getJSONObject("product_description").getString("title");
			return productName;
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
