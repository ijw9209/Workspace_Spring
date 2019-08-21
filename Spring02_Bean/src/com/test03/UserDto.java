package com.test03;

import java.util.Date;

public class UserDto {

	private String name;
	private Date myDate;
	
	public UserDto() {
		
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
	public Date getMydate() {
		return myDate;
	}
	public void setMydate(Date mydate) {
		this.myDate = mydate;
	}
	
	
}
