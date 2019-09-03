package com.hello.mvc03.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAop {

	@Before("execution(public * com.hello.mvc03.model.dao.*Dao*.*(..))")
	public void before(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		
		logger.info("===================loger start==============");
		Object args[] = join.getArgs();
		if(args != null) {
			logger.info("Method : " + join.getSignature().getName());
			for(int i = 0; i < args.length; i++) {
				logger.info(i + "번째 :" + args[i]);
			}
		}
		/*
		 * .getTarget() : 대상 객체
		 * .getArgs() : 대상 파라미터
		 * .getSignature : 대상 메서드 정보
		 * 
		 */
	}
	@After("execution(public * com.hello.mvc03.model.dao.*Dao*.*(..))")
	public void after(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		logger.info("================loger end==============");
	}
	@AfterThrowing("execution(public * com.hello.mvc03.model.dao.*Dao*.*(..))")
	public void afterThrowing(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget() + "");
		logger.info("error : " + join.getArgs());
		logger.info("error : " + join.toString());
	}
}
