package com.capgemini.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoginDemoAspect {

	
	@Pointcut("execution(* com.capgemini.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	@Pointcut("execution(* com.capgemini.aopdemo.dao.*.set*(..))")
	private void setter() {}
	@Pointcut("execution(* com.capgemini.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("forDaoPackage() && !(setter() || getter())")
	private void forDaoPackageNoGetterAndSetter() {}
	
	@Before("execution(public void com.capgemini.aopdemo.dao.AccountDAO.addAccount())")
	public void loggigAspect() {
		System.out.println("####### ::: Logging the steps");
	}
	
	

	//@Before("execution(* add*(com.capgemini.aopdemo.Account,..))")
	//@Before("execution(* com.capgemini.aopdemo.dao.*.*(..))")
	//@Before("execution(* add*(..))")
	@Before("forDaoPackageNoGetterAndSetter()")
	public void loggigAspects() {
		System.out.println(" ######### **** Logging the new steps");
	}
}
