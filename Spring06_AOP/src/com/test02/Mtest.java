package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mtest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		System.out.println("여학생 입장");
		Person w = (Person) factory.getBean("woman");		// w m : target cc
		w.classWork();		//join point : 메소드호출할때	//proxy : 자기가 타겟인척함  ccc
							//join point 에  advice 엮음 point cut public *(리턴타입 상관없음) *(이름 상관없음)(..)(파라미터타입 상관없음)
		System.out.println("-----------");
		System.out.println("남학생 입장");
		Person m = (Person) factory.getBean("man");
		m.classWork();
	}
}
