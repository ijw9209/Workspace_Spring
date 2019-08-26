package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mtest {
	
	public static void main(String[] args) {
		
		ApplicationContext factroy = new ClassPathXmlApplicationContext("com/test05/applicationContext.xml");
		Person w = (Person) factroy.getBean("woman");
		System.out.println("여학생 입장");
		w.classWork();
		
		System.out.println("======================");
		Person m = (Person) factroy.getBean("man");
		System.out.println("남학생 입장");
		m.classWork();
	}

}
