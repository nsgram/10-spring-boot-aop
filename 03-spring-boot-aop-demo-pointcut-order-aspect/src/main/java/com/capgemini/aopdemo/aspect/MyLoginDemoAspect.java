package com.capgemini.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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
}