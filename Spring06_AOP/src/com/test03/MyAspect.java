package com.test03;

import org.aspectj.lang.JoinPoint;

public class MyAspect {

	public void before(JoinPoint join) {
		System.out.println("출석 카드 찍는다");
	}
	public void after(JoinPoint join) {
		System.out.println("집에 간다");
	}
	public void afterThrowing(JoinPoint join) {
		System.out.println("쉬는날이다");
	}
}
