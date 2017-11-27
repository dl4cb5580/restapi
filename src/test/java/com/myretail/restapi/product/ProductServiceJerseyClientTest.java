package com.myretail.restapi.product;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ProductServiceJerseyClientTest {
	
	private String baseURL = "http://localhost:8080/myretail/api/v1/products/";
	
	
	public void testGetProduct(int productId) {
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(baseURL+productId);
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			String output = response.getEntity(String.class);
			Product product = new ObjectMapper().readValue(output, Product.class);
			System.out.println(product);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void testUpdateProduct(int productId, Product product) {
		try {
			String productJsonString =  new ObjectMapper().writeValueAsString(product);
			Client client = Client.create();
			WebResource webResource = client.resource(baseURL+productId);
			ClientResponse response = webResource.type("application/json").put(ClientResponse.class, productJsonString);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "  + response.getStatus());
			}
			String output = response.getEntity(String.class);
			product = new ObjectMapper().readValue(output, Product.class);
			System.out.println(product);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ProductServiceJerseyClientTest productServiceJerseyClientTest = new ProductServiceJerseyClientTest();
		try {
			productServiceJerseyClientTest.testGetProduct(13860428);
			productServiceJerseyClientTest.testUpdateProduct(13860428, new Product(13860428, "The Big Lebowski (Blu-ray) (Widescreen)", new Price(11.11, "USD")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
