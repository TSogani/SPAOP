package com.aa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class loggingAspect {

	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = null;
		Object[] arguments = null;

		methodName = pjp.getSignature().getName();
		arguments = pjp.getArgs();
		
		String keyGenrator = keyGenrator(arguments);
		
		System.out.println("Enter Into " + methodName + "  "+ pjp.getThis().getClass().getName() + keyGenrator);
		
		Object proceed = pjp.proceed();
		
		System.out.println("Exit from " + methodName + " "+keyGenrator+" : Return Value "+proceed );
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
