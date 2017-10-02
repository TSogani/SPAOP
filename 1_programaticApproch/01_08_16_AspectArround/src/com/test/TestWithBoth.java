package com.test;

import org.springframework.aop.framework.ProxyFactory;

import com.beans.CacheAspectAround;
import com.beans.Calculator;
import com.beans.LoggingAspectArround;

public class TestWithBoth {

	public static void main(String[] args) {

		ProxyFactory pfactory = new ProxyFactory();
		pfactory.setTarget(new Calculator());
		
		
		
		pfactory.addAdvice(new CacheAspectAround());
		pfactory.addAdvice(new LoggingAspectArround());
		
		Calculator proxy = (Calculator) pfactory.getProxy();
		proxy.add(10, 20);
		proxy.add(10, 20);
		proxy.add(10, 20);
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
