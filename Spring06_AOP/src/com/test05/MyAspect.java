package com.test05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	
	// pointcut 으로 사용할 empty class
	//Joinpoint() target 에 무언가를 사용하고싶을때쓰임
	@Pointcut("execution(public * *(..))")
	public void myClass() {}
	
	@Before("myClass()")
	public void before() {
		System.out.println("출석 카드 찍는다.");
	}
	@After("myClass()")
	public void after() {
		System.out.println("집에 간다.");
	}
}
