package com.test;

import org.springframework.aop.framework.ProxyFactory;

import com.beans.CheckingPerformanceAspects;
import com.beans.ChekingOfPerformance;

public class TestPerformance {
	public static void main(String[] args) throws InterruptedException {
		
		ProxyFactory factory = new ProxyFactory();
		factory.addAdvice(new CheckingPerformanceAspects());
		factory.setTarget(new ChekingOfPerformance());
		
		ChekingOfPerformance proxy = (ChekingOfPerformance) factory.getProxy();
		proxy.calculate(10, 20);
	}

}
