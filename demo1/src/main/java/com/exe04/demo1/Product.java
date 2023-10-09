package com.exe04.demo1;

public class Product {
	private String code;
	private String description;
	private double price;
	private int amount;

	public Product(String code, String description, double price, int amount) {
		this.code = code;
		this.description = description;
		this.price = price;
		this.amount = amount;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getAmount() {
		return amount;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
