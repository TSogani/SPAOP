package com.aa.test;

import org.springframework.aop.framework.ProxyFactory;

import com.aa.aspect.CacheAspectAround;
import com.aa.aspect.LoggingAspectArround;
import com.aa.beans.Calculator;

public class TestWithBoth {

	public static void main(String[] args) {

		ProxyFactory pfactory = new ProxyFactory();
		
		// setCalculator
		pfactory.setTarget(new Calculator());
		
		// cache aspect 
		pfactory.addAdvice(new CacheAspectAround());
		
		//logging aspect 
		pfactory.addAdvice(new LoggingAspectArround());
		
		// getProxy
		Calculator proxy = (Calculator) pfactory.getProxy();

		proxy.add(10, 20);
		proxy.add(10, 20);
		proxy.add(10, 20);
	//	proxy.add();
	}
}

/*			-- First logging Aspect--
entered into add(11,20)
search key with add(add(11,20)
put value with add(add(11,20)
method return : 31
end of add
entered into add(11,20)
search key with add(add(11,20)
get Value with Keyadd(add(11,20)
end of add
entered into add(11,20)
search key with add(add(11,20)
get Value with Keyadd(add(11,20)
end of add
*/

/*   -- -- First cache Aspect--

 search key with add(add(10,20)
entered into add(11,20)
end of add
put value with add(add(10,20)
method return : 33

search key with add(add(10,20)
get Value with Keyadd(add(10,20)
search key with add(add(10,20)
get Value with Keyadd(add(10,20)
*/

 // we alwayz apply  cacheing first,  
	//if we apply logging first, in really control not goes to target class but logging display message, like. control goes to target clss. so may be developer confuse. 
	// if we apply cacheing first ,  devloper esyly understand, that value comes from cache or control goes to target class or not. 
