package com.test06;

public class Emp {

	private String name;
	private String salary;
	public Emp() {
		super();
	}
	public Emp(String name, String salary) {
		super();
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
		return "이름 : " + name + "\t 월급 : " + salary ;
	}
	
	
	
}
