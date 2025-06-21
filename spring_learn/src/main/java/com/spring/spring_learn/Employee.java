package com.spring.spring_learn;

public class Employee {

	private double empId;
	private String name;
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public double getEmpId() {
		return empId;
	}

	public void setEmpId(double empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee(double empId, String name, Address address) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + "]";
	}

}
