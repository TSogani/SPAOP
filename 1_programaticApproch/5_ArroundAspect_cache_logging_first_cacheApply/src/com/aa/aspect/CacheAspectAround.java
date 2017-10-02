package com.aa.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CacheAspectAround implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		String methodName = methodInvocation.getMethod().getName();
		Object[] arguments = methodInvocation.getArguments();
		
		String key = buildKey(methodName,arguments);
		Cache cache = Cache.getInstance();
		
		if(cache.containtsKey(key)){
			
			return cache.get(key);
		}
		Object retuenValueOfTarget = methodInvocation.proceed();
		
		cache.put(key, retuenValueOfTarget);
		
		System.out.println("method return : "+retuenValueOfTarget);
		return retuenValueOfTarget;
	}
	public String buildKey(String methodName,Object[] argument){
			String key="";
			key = methodName+"(";
					for(int i=0;i<argument.length;i++){
						if(i == 0){
				//			key = key+argument[0]; // this is not good way of writing code 
							key += argument[0];
							continue;
						}
						key += ","+argument[i]+")";
					}
		return key;
	}
}
