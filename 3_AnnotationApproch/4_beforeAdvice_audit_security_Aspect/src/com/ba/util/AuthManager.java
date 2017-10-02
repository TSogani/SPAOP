package com.ba.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AuthManager  implements ApplicationContextAware{
	ThreadLocal<Cridential> credentialWallet;
	Cridential cridential;

	public AuthManager() {
	//	cridential = new Cridential(); // dont do in this way
		credentialWallet = new ThreadLocal<Cridential>();
		
	}

	
	
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {

		cridential  = context.getBean("cridential",Cridential.class);
	}



	public void login(String username, String password) {
		
		
		cridential.setUsername(username);
		cridential.setPassword(password);

		credentialWallet.set(cridential);
		
	}

	public void logout() {
		cridential = null;
	}

	public String getLoggedUser(){
		Cridential crid =null;
		crid = credentialWallet.get();
		System.out.println("crid : " +crid);
		
		if(cridential != null){
			String username = crid.getUsername();
			System.out.println(username);
			return username;
		}
		return null;
	}

	public boolean authantication() {
		Cridential crid = null;
		crid = credentialWallet.get();
		if (crid != null) {
			if (crid.getUsername().equals("john")
					&& crid.getPassword().equals("welcome")) {
				return true;
			}
		}
		return false;
	}
}
