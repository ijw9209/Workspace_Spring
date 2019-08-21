package com.test02;

public class Address {

	private String name;
	private String addr;
	private String tel;
	public Address() {
		
	}
	public Address(String name,String addr , String tel) {
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setaddr(String addr) {
		this.addr = addr;
	}
	public String getaddr() {
		return addr;
	}
	public void settel(String tel) {
		this.tel = tel;
	}
	public String gettel() {
		return tel;
	}
	@Override
	public String toString() {
		return "Address [name=" + name + ", addr=" + addr + ", tel=" + tel + "]";
	}
	
	
}
