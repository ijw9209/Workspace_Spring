package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mtest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		Bar bar = (Bar) factory.getBean("bar");
		bar.pr();
		
		
		Foo foo = (Foo) factory.getBean("Foo");
		
		
		Score score = (Score) factory.getBean("sc");
	}
}
