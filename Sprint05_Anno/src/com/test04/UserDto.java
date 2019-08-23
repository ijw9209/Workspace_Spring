package com.test04;

public class UserDto {

	private String name;
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}
	public UserDto(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}
	
}
