package com.test05;

public class Emp {

	private String name;
	private String salary;

	public Emp() {
	}

	public Emp(String name, String salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return name + " \t월급 : " + salary;
	}

}
