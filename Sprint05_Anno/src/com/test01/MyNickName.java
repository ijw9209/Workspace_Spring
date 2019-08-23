package com.test01;

public class MyNickName {

	private NickName nickName;
	
	public MyNickName() {
	}

	public void setNickName(NickName nickName) {
		this.nickName = nickName;
	}
	
	public String toString() {
		return "나의 " + nickName;
	}
}
