package com.capgemini.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.capgemini.aopdemo.Account;
@Aspect
@Component
@Order(1)
public class MyLoginDemoAspect {
	@Before("com.capgemini.aopdemo.aspect.AopPointCutExpression.forDaoPackageNoGetterAndSetter()")
	public void beforAddAccountAdvice(JoinPoint joinpoint) {
		
		System.out.println("####### ::: executing @Before advice on the method");
		//display method signature
		MethodSignature signature = (MethodSignature) joinpoint.getSignature();
		System.out.println("Method :"+signature);
		//Display method argument
		System.out.println("Method arguments ::");
		Object[] params = joinpoint.getArgs();
		for (Object args : params) {
			System.out.println("=== "+args +"===");
		}
	}
	
	@AfterReturning(pointcut =  "execution(* com.capgemini.aopdemo.dao.AccountDAO.findAccounts(..))",
			       returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint joinPoint , List<Account> result) {
		// point out which method we are 
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(" ::: executing after return -> "+methodName);
		covertNameInLowerCase(result);
		if(!result.isEmpty()) {
			Account account = result.get(0);
			account.setName("Daffy duck");
		}
		//print out the result of method
		System.out.println("result is ::"+result);
	}

	private void covertNameInLowerCase(List<Account> result) {
		for(Account account: result) {
			account.setName(account.getName().toLowerCase());
		}	
	}
	
	@AfterThrowing(pointcut =  "execution(* com.capgemini.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc")
	public void AfterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable theExc) {
		
		// print out which method advising
		
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(" ::: executing after throwing -> "+methodName);
		
		//log the Exception
		
		System.out.println("============>>> the exception is :::"+theExc);
		
	}
	
	@After("execution(* com.capgemini.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void AfterFindAccountAdvice(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(" ::: executing after advice -> "+methodName);
		
		System.out.println("======= I am from after advice");
	}
	
	@Around("execution(* com.capgemini.aopdemo.service.*.getFortune(..))")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String methodName = proceedingJoinPoint.getSignature().toShortString();
		System.out.println(" ::: executing after ===>>> "+methodName);
		long begin = System.currentTimeMillis();
		Object result  = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			//log exception
			System.out.println(" @Around advice : we have problem "+e.getMessage());
			//result = "Majot accident!  but no worries, your private helicopter is on the way";
			
			//re throw exception
			throw e;
		}
				
				
				
		long end = System.currentTimeMillis();
		long duration = end - begin;
		System.out.println("====>>> duration ["+duration/1000 +"]SECOND");
		return result;
	}
	
}