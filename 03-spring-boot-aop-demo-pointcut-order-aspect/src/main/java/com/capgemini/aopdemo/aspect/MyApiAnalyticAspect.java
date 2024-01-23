package com.capgemini.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticAspect {
	
	@Before("com.capgemini.aopdemo.aspect.AopPointCutExpression.forDaoPackageNoGetterAndSetter()")
	public void performApiAnalyticAdvice() {
		System.out.println("******* ::: Performing API analytics");
	}

}
