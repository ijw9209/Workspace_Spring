package com.test02;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class School {

	@Autowired
	//Qualifier는 type부터 먼저 찾고 안되면 name으로찾음
	//Resource는 name먼저 type나중에
	//@Qualifier("lee")
	@Resource(name="hong")
	private Student person;
	private int grade;
	
	
	public School() {
		// TODO Auto-generated constructor stub
	}

	public School(Student person, int grade) {
		super();
		this.person = person;
		this.grade = grade;
	}

	public Student getPerson() {
		return person;
	}

	public void setPerson(Student person) {
		this.person = person;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "School [person=" + person + ", 등급=" + grade + "]";
	}
	
}
