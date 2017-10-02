package com.ar.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@ComponentScan("com.ar.beans")
@Component
@EnableAspectJAutoProxy
@Aspect
public class KeyValidateAfterReturingAspect {
	@AfterReturning(value="execution(* com.ar.beans.*.*(..))" , returning="genratorKey")
	public void doCheck(JoinPoint jp, boolean genratorKey){
		if (!genratorKey) {
			throw new IllegalArgumentException("Key size should be 8 ");
		}else{
			System.out.println("key successfully genrated ");
		}
	}
}
