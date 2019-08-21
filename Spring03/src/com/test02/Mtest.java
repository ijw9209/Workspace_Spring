package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mtest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		BirthDto dto = (BirthDto) factory.getBean("dto");
		System.out.println(dto);
		
		BirthDto lee = (BirthDto) factory.getBean("lee");
		System.out.println(lee);
		//1.왼쪽짝궁의 이름과 생일을 setter를 사용하여 값을 주입하고 출력
			//1994년 4월13일
		//2. 오른쪽짝궁의 이름과 생일을 생성자를 사용하여 값을 주입하고 출력
			
		//3. 내이름과 생일을(마음대로)값을 주입하고 출력하자
	}
}
