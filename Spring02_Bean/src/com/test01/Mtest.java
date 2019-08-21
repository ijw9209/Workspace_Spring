package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mtest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		MessageBean apple = (MessageBean) factory.getBean("apple");
		apple.sayHello();
		
		MessageBean watermelon = (MessageBean) factory.getBean("watermelon");
		watermelon.sayHello();
		
		MessageBean jadu = (MessageBean) factory.getBean("jadu");
		jadu.sayHello();
		
		((ClassPathXmlApplicationContext)factory).close();
	}

}
