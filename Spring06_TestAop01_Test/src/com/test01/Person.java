package com.test01;


public class Person implements Human {

	protected String name;
	protected String job;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	public String sayName(String name) {
		return "나의 이름은 " + name + "입니다";
	}

	@Override
	public String sayJob(String job) {
		return "나의 직업은 " + job + "입니다";
	}

}
