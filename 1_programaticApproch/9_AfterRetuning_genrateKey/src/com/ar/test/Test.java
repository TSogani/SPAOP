package com.ar.test;

import org.springframework.aop.framework.ProxyFactory;

import com.ar.aspect.ValidKeyAspect;
import com.ar.beans.KeyGenrator;

public class Test {
	public static void main(String[] args) {

			ProxyFactory pFactory = new ProxyFactory();
			pFactory.setTarget(new KeyGenrator());
			pFactory.addAdvice(new ValidKeyAspect());
			
			KeyGenrator key = (KeyGenrator)	pFactory.getProxy();
			boolean genrateKey = key.genrateKey(5);
			if (genrateKey) {
				System.out.println("valid");
			}else{
				System.out.println("invalid");
			}
	}

}
