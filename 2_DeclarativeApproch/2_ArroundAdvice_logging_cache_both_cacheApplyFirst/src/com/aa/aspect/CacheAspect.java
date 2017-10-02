package com.aa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import com.aa.util.Cache;

public class CacheAspect {

	private Cache cache = null;

	public void setCache(Cache cache) {
		this.cache = cache;
	}

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
