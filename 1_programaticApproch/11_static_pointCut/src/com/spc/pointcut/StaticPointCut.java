package com.spc.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import com.spc.beans.Calculator;

public class StaticPointCut extends StaticMethodMatcherPointcut{

	@Override
	public boolean matches(Method methodName, Class<?> classz) {
		if(classz.isAssignableFrom(Calculator.class)  && (methodName.getName()).equals("add")){
			
			return true;
			
		}
		return false;
	}

	
}
