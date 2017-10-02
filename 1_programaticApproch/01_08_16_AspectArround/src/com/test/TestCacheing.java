package com.test;

import org.springframework.aop.framework.ProxyFactory;

import com.beans.CacheAspectAround;
import com.beans.Calculator;

public class TestCacheing {
	public static void main(String[] args) {
		
		ProxyFactory proxyFactory = new  ProxyFactory();
		
		CacheAspectAround cacheAsceptArround = new CacheAspectAround();
		//Calculator calculator = new Calculator();
		proxyFactory.addAdvice(cacheAsceptArround);
		proxyFactory.setTarget(new Calculator());
		
		Calculator proxy =(Calculator) proxyFactory.getProxy();

		int returnOfAdd = proxy.add(10, 20);
		
		 returnOfAdd = proxy.add(10, 20);
		 returnOfAdd = proxy.add(10, 20);
		System.out.println(returnOfAdd );
	}
}
