package com.maulik.spring.hibernate.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LoggingInAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.maulik.spring.hibernate.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.maulik.spring.hibernate.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.maulik.spring.hibernate.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void beforeLogging(JoinPoint theJoinPoint) {
		 
		String theMethod = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("Before advice" + theMethod);
		
		Object[] args = theJoinPoint.getArgs();
		
		for (Object tempArgs : args) {
			
			myLogger.info("before advice variables " + tempArgs);
		}
		
	}
	
	@AfterReturning(pointcut="forAppFlow()",returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		String theMethod = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("AfterReurning advice " + theMethod);
		
		myLogger.info("AfterReurning result " + theResult);
	}

}
