package com.dpc.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import com.dpc.beans.Calculator;

public class DynamicPointCut extends DynamicMethodMatcherPointcut{

	@Override
	public boolean matches(Method methodName, Class<?> classz, Object[] argument) {

		if(classz.isAssignableFrom(Calculator.class) && methodName.getName().equals("add") && (Integer)argument[0] >= 0 && (Integer)argument[1]>= 0){
			return true;
		}
		return false;
	}

	
}
