package com.test02;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mtest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		MemberInfo obj = (MemberInfo) factory.getBean("member");
		System.out.println("obj : " + obj);
		int num = (int)(Math.random()*2);
		if(num == 0) {							
//(String code, Object[] args, String defaultMessage : 실패했을때 나오는 메세지,
//Locale locale : 기본값은 지금설정되있는 값이 디폴트값)
			String message = factory.getMessage("title", null,"기본메세지" ,Locale.getDefault());
			System.out.println("message : " + message);
			obj.display(Locale.getDefault());
		}else {
			String message = factory.getMessage("title", null ,"default message " , Locale.ENGLISH);
			System.out.println(message);
			obj.display(Locale.ENGLISH);
		}
		
		
	}

}
