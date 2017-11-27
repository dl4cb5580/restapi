package com.myretail.restapi.product;

public class Product {

	private int id;
	private String name;
	private Price current_price;
	
	public Product() {
		super();
	}
	
	public Product(int id, String name, Price current_price) {
		super();
		this.id = id;
		this.name = name;
		this.current_price = current_price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Price getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(Price current_price) {
		this.current_price = current_price;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=").append(id).append(", name=").append(name).append(", current_price=")
				.append(current_price).append("]");
		return builder.toString();
	}
	
}
