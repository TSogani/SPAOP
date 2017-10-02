package com.ar.aspect;

import org.aspectj.lang.JoinPoint;

public class AfterAspectKeyChker {
	public void keyChecker(JoinPoint jp, boolean genratedKeyReturn){
		if (!genratedKeyReturn) {
			throw new IllegalArgumentException("Key length is 8 only");			
		}else{

			System.out.println("Key is perfact, valid ");
		}
	}
}
