package com.test06;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	
	@Before("execution(public * * (..))")
	public void before() {
		System.out.println("출석카드 찍는다");
	}
	@After("execution(public * * (..))")
	public void after() {
		System.out.println("집에간다.");
	}
}
