package com.aa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import com.aa.util.Cache;

public class CacheAspect {
	private Cache cache = null;

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	public Object doCache(ProceedingJoinPoint pjp,int x,int y) throws Throwable {
		String methodName = null;
		Object[] args = null;
		String key = null;
		Object ret = null;
		
		args = pjp.getArgs();
		
		key = makeKey(args);
		
		if(cache.ContainsKey(key)){
			return cache.get(key);
		}else{
			ret = pjp.proceed();
			cache.put(key, ret);
		}
		return ret;

	}

	public String makeKey(Object[] args) {
		String key = null;
		key = "(";
		for (int i = 0; i < args.length; i++) {
			if(i==0){
				key += args[i];
			}
			key += ","+args[i];
		}
		key += ")";
		
		return key;
	}
}
