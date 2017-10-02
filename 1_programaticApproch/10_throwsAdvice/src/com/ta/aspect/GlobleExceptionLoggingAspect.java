package com.ta.aspect;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class GlobleExceptionLoggingAspect implements ThrowsAdvice{
// ThrowsAdvice is a marker Interface
	
	
	// afterThrowing this method name is fix 
	// otherWise we get - 
	// Could not generate CGLIB subclass of class [class com.ta.beans.Thrower]: Common causes of this problem include using a final class or a non-visible class; nested exception is java.lang.IllegalArgumentException: At least one handler method must be found in class [class com.ta.aspect.GlobleExceptionLoggingAspect]
	
	/*public void afterThrowing(IllegalArgumentException iae){
		System.out.println("Execption : "+iae);
	}*/
	
	public void afterThrowing(Method methodName, Object[] arguments, Object terget,IllegalArgumentException iae){
		System.out.println(methodName.getName() +" "+iae);
	}
	
	
}






//ThrowsAdvice is an marked interface.
//afterThrowing method name is fixed.
//always max parameter method got executed.
//if Exception is exject match then execute first method which we write.
//if we declare afterThrowing(Exception e) then also exject match method got executed. 