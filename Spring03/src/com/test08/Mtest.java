package com.test08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mtest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test08/applicationContext.xml");
		
		SamsongTV sam = (SamsongTV) factory.getBean("Samsong");
		sam.powerOn();
		sam.powerOff();
		sam.volumeUp();
		sam.volumeDown();
		
//		LzTV lz = factory.getBean("Lz",LzTV.class);
//		lz.powerOn();
//		lz.powerOff();
//		lz.volumeUp();
//		lz.volumeDown();
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}
