package com.capgemini.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
}