package com.learm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Student {
	@Value("hello")
	private String name;
	
	private Address address;

	public Address getAddress() {
		this.address.display();
		System.out.println("study now");
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + "]";
	}

	
	
	
}
