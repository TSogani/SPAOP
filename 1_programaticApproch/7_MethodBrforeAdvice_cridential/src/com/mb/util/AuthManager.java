package com.mb.util;

import com.mb.beans.Creadentials;


public class AuthManager {
	
	private static AuthManager instance;
	ThreadLocal<Creadentials> creadentialsWallet;
	
	private AuthManager(){
		// no opp
		creadentialsWallet  = new ThreadLocal<Creadentials>();
	}
	public synchronized static AuthManager getinstance(){
		if(instance == null){
			instance = new AuthManager();
		}
		return instance;
	}
	
	public void login(String username,String password){
		System.out.println(username +" :"+ password);
		Creadentials creadentials = new Creadentials();
		creadentials.setUsername(username);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// switching
		creadentials.setPassword(password);
		creadentialsWallet.set(creadentials);
	}
	
	public void logout(){
		creadentialsWallet = null; 
	}
	public boolean authantication(){
		Creadentials  creadentials; 
		creadentials = creadentialsWallet.get();
		if(creadentials != null){
			if(creadentials.getUsername().equals("john") && creadentials.getPassword().equals("welcome")){
				return true;
			}
		}
		return false;
	}
	
	public String getLoggedUser(){
		Creadentials creadentials = null;
		creadentials = creadentialsWallet.get();
		String username = creadentials.getUsername();
		return username;
	}
}
