package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mtest {
	
	public static void main(String[] args) {
		ApplicationContext beans = new ClassPathXmlApplicationContext("com/test03/beans.xml");
		
		Emp you = (Developer)beans.getBean("you");
		System.out.println(you);
		
		Emp kang = (Engineer) beans.getBean("kang");
		System.out.println(kang);
	
	}

}
