package com.test02;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

// 메세지 국제화를 위해 사용
// MessageSourceAware는 번들이 지정한 properties 파일을 
// setMessageSource()로 전달한다.

//ResourceBundleMessageSource 의 setBaseName()을 통해
//전달받은 파일을 , setMessageSource()를 자동으로 호출해서 매핑한다


//MessageSourceAware 와 ResourceBundleMessageSource는 쌍으로 사용한다.

public class MemberInfo implements MessageSourceAware{
	
	//전달된 properties
	//변수 = 값을 읽어서 파싱
	private MessageSource message;
	
	
	@Override
	public void setMessageSource(MessageSource messageSource) {
		System.out.println("컨테이너가 메세지 설정을 수행중...");
		this.message = messageSource;
		System.out.println(message);
		
	}
	//properties 키와값 쌍으로 구성
	//{0} << 나중에 다른값으로 치환될수있는 부분
	public void display(Locale locale) {
		String name = message.getMessage("member.name", null, locale);
		String birthplace = message.getMessage("member.birthplace", null, locale);
		String hobby = message.getMessage("member.hobby",new Object[] {"13"}, null, locale);
		String age = message.getMessage("member.age",new Object[] {"13"},null, locale);
		
		System.out.println("locale : " + locale);
		System.out.println(name);
		System.out.println(birthplace);
		System.out.println(hobby);
		System.out.println(age);
		
	}
	
}
