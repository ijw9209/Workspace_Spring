package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mtest {
	//TODO : 004. SERVICE 객체의 addUser 호출
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		
		UserServiceImpl service = (UserServiceImpl) factory.getBean("userService");
		service.addUser();
	}
}
