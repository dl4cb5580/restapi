package com.myretail.restapi.product;

public class Price {
	
	private double value;
	private String currency_code;
	
	public Price() {
		super();
	}
	
	public Price(double value, String currency_code) {
		super();
		this.value = value;
		this.currency_code = currency_code;
	}
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getCurrency_code() {
		return currency_code;
	}
	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Price [value=").append(value).append(", currency_code=").append(currency_code).append("]");
		return builder.toString();
	}

}
