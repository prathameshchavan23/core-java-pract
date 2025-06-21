package com.learn.lifecycle;

public class Bean {

	private double Price;

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		System.out.println("Setting the price");
		Price = price;
	}


	public Bean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bean [Price=" + Price + "]";
	}
	
	// we have to tell bean that we have these methods
	public void init() {
		System.out.println("Inside init method");
	}
	
	public void destroy() {
		System.out.println("Inside destroy");
	}
	
}
