package com.capgemini.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopPointCutExpression {
	
	@Pointcut("execution(* com.capgemini.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	@Pointcut("execution(* com.capgemini.aopdemo.dao.*.set*(..))")
	public void setter() {}
	@Pointcut("execution(* com.capgemini.aopdemo.dao.*.get*(..))")
	public void getter() {}
	@Pointcut("forDaoPackage() && !(setter() || getter())")
	public void forDaoPackageNoGetterAndSetter() {}
}
