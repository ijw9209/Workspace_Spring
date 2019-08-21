package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mtest {

	public static void main(String[] args) {
		ApplicationContext factroy = new ClassPathXmlApplicationContext("com/test04/beans.xml");
		
		Developer dyou = (Developer) factroy.getBean("dyou");
		System.out.println(dyou);
		
		Engineer dkang = (Engineer) factroy.getBean("dkang");
		System.out.println(dkang);
	}
}
