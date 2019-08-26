package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mtest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		
		//프록시가 인터페이스 기준이라 woman 타입으로하면 에러남
		Person w = (Person) factory.getBean("woman");
		System.out.println("여학생 입장");
		w.classWork();
		
		System.out.println("============");
		System.out.println("남학생 입장");
		Person m = (Person) factory.getBean("man");
		m.classWork();
	}

}
