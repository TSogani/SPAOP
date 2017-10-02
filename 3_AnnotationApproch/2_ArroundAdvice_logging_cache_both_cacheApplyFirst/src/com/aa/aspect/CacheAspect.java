package com.aa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aa.util.Cache;

@Component
@Aspect
@Order(value=1)

public class CacheAspect {
	
	@Autowired
	private Cache cache = null;

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	@Around(value="execution (* com.aa.beans.*.*(..))")
	public Object doCache(ProceedingJoinPoint pjp) throws Throwable {
		Object returnVal = null;
		// String methodName = pjp.getSignature().getName();
		Object[] arguments = pjp.getArgs();

		String key = makeKey(arguments);

		System.out.println(key);

		if (cache.cantainsKey(key)) {
			returnVal = cache.get(key);
		} else {
			returnVal = pjp.proceed();
			cache.put(key, returnVal);
		}
		return returnVal;
	}

	public String makeKey(Object[] args) {
		String key = null;
		key = "(";
		for (int i = 0; i < args.length; i++) {
			if (i == 0) {
				key += args[i];
			} else {
				key += "," + args[i];
			}
		}
		key += ")";

		return key;
	}
}
