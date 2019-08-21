package com.test05;

public class Developer {

	private Emp emp;
	private String dept;
	
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDept() {
		return dept;
	}
	public String toString() {
		return emp + " \t 부서 : " + dept;
	}
}
