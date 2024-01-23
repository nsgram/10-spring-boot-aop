package com.capgemini.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoginAspect {

	
	@Before("execution(public void com.capgemini.aopdemo.dao.AccountDAO.addAccount())")
	public void loggigAspect() {
		System.out.println("####### ::: Logging the steps");
	}
	
	

	//@Before("execution(* add*(com.capgemini.aopdemo.Account,..))")
	@Before("execution(* com.capgemini.aopdemo.dao.*.*(..))")
	//@Before("execution(* add*(..))")
	public void loggigAspects() {
		System.out.println(" ######### **** Logging the new steps");
	}
}
