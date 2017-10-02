package com.at.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
@ComponentScan("com.at.beans")
@Component
@EnableAspectJAutoProxy
@Aspect
public class AfterThrowingAspect {
	@Pointcut("execution(* com.at.beans.*.*(..))")
	public void handle(JoinPoint jp, IllegalArgumentException iae){
		System.out.println("Exception on"+iae.getMessage());
	}
}
