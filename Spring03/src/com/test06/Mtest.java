package com.test06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mtest {

	public static void main(String[] args) {
		
		ApplicationContext factroy = new ClassPathXmlApplicationContext("com/test06/beans.xml");
		
		Developer dyou = (Developer) factroy.getBean("dyou");
		System.out.println(dyou);
		
		Engineer ekang = (Engineer) factroy.getBean("ekang");
		System.out.println(ekang);
		
		
		((ClassPathXmlApplicationContext)factroy).close();
	}
}
