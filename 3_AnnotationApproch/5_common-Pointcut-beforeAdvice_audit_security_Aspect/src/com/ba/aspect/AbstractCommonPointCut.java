package com.ba.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AbstractCommonPointCut {
	@Pointcut("execution(* com.ba.beans.*.*(..))")
	public void commonPointCut(){
		
	}
}
