package com.luv2code.springboot.thymeleafdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DomoLoginAspect {
	//setup logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//set point cut declaration
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
	private void forServicePackage() {}
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage()|| forServicePackage() || forDaoPackage()")
	public void forAppFlow() {}
	
	//Adding @Befor advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		String name = theJoinPoint.getSignature().toShortString();
		logger.info("===>>> in @Before "+name);
		//display the argument to the method
		
		//get the argument
		Object[] args = theJoinPoint.getArgs();
		for (Object tempArgs : args) {
			logger.info("===>>> argument ::"+tempArgs);
		}
		
	}
	//Adding @AfterReturning
	@AfterReturning(pointcut = "forAppFlow()",
			      returning = "theResult")
	public void afterReturning(JoinPoint joinPoint, Object theResult) {
		//Display method where are returning from
		
		String name = joinPoint.getSignature().toShortString();
		logger.info("===>>> in @AfterReturning "+name);
		//display the argument to the method
		logger.info("====>>> result ::"+theResult);
	}
}
