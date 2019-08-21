package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mtest {

	public static void main(String[] args) {
		
		ApplicationContext beans = new ClassPathXmlApplicationContext("com/test02/beans.xml");
		
		Address hong = (Address) beans.getBean("hong");
		Address lee = (Address) beans.getBean("lee");
		Address kim = (Address) beans.getBean("kim");
		
		System.out.println(hong);
		System.out.println(lee);
		System.out.println(kim);
		
		JobAddress jhong = beans.getBean("jHong",JobAddress.class);
		System.out.println(jhong);
		
		JobAddress jlee = (JobAddress) beans.getBean("jlee");
		System.out.println(jlee);
		
		JobAddress jKim = (JobAddress) beans.getBean("jKim");
		System.out.println(jKim);
		
		
		((ClassPathXmlApplicationContext)beans).close();
	}
}
