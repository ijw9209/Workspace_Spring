package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mtest {

	public static void main(String[] args) {
		ApplicationContext beans = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		MyNickName mynick = (MyNickName) beans.getBean("Mynickname");
		System.out.println(mynick);
	}
}
