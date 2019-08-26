package com.test06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mtest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test06/applicationContext.xml");
		
		Person w = (Person) factory.getBean("woman");
		System.out.println("여학생입장!");
		w.classWork();		//join point 
		
		System.out.println("================");
		Person m = (Person) factory.getBean("man");
		System.out.println("남학생 입장");
		m.classWork();
	}
}
