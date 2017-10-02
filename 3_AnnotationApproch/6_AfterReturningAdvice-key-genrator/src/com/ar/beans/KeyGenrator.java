package com.ar.beans;

import org.springframework.stereotype.Component;

@Component
public class KeyGenrator {
	public boolean genratorKey(int lenKey){
		
		if(lenKey == 8){
			return true;
		}
		return false;
	}
}
