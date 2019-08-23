package com.test01.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mtest {

	public static void main(String[] args) {
		ApplicationContext bean = new ClassPathXmlApplicationContext("com/test01/anno/beans.xml");
		
		MyNickName my = bean.getBean("myNickName" ,MyNickName.class);
		System.out.println(my);
	}
}
