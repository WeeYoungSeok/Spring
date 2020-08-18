package com.test02;

public class Food {

	private String name;
	private int price;
	
	public Food() {
		
	}
	
	public Food(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return name + " \t " + price;
	}
}
