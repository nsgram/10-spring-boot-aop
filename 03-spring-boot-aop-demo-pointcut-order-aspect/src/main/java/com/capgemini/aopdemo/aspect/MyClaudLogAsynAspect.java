package com.capgemini.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyClaudLogAsynAspect {
	@Before("com.capgemini.aopdemo.aspect.AopPointCutExpression.forDaoPackageNoGetterAndSetter()")
	public void logToCloudAdvice() {
		System.out.println("+++++++ ::: Login on cloud in async fashion");
	}
}
