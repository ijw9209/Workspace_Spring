package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mtest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test05/beans.xml");
		
		Developer dyou = (Developer) factory.getBean("dyou");
		System.out.println(dyou);
		
		Engineer dkang = (Engineer) factory.getBean("dkang");
		System.out.println(dkang);
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}
