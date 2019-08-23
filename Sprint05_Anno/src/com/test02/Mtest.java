package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mtest {

	public static void main(String[] args) {
		ApplicationContext beans = new ClassPathXmlApplicationContext("com/test02/beans.xml");
		
		School sc = (School) beans.getBean("school");
		System.out.println(sc);
	}

}
