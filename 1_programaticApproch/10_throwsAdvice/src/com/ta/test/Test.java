package com.ta.test;

import org.springframework.aop.framework.ProxyFactory;

import com.ta.aspect.GlobleExceptionLoggingAspect;
import com.ta.beans.Thrower;


public class Test {

	public static void main(String[] args) {

		ProxyFactory pFactory = new ProxyFactory();
		pFactory.setTarget(new Thrower());
		pFactory.addAdvice(new GlobleExceptionLoggingAspect());
		
		Thrower th = (Thrower)pFactory.getProxy();
		int willThrow = th.willThrow(1);
		System.out.println(willThrow);
	}

}
