package com.aa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(value=2)
public class loggingAspect {

	@Around(value="execution(* com.aa.beans.*.*(..))")
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = null;
		Object[] arguments = null;

		methodName = pjp.getSignature().getName();
		arguments = pjp.getArgs();
		
		String keyGenrator = keyGenrator(arguments);
		
		System.out.println("Enter Into " + methodName + " " + keyGenrator);
		
		Object proceed = pjp.proceed();
		
		System.out.println("Exit from " + methodName);
		
		return proceed;
	}

	public String keyGenrator(Object[] arguments) {
		String key = "{";
		for (int i = 0; i < arguments.length; i++) {

			if (i == 0) {
				key += arguments[i];
			} else {
				key += "," + arguments[i];
			}
		}
		key += "}";
		return key;
	}
}
