package com.ar.beans;

public class KeyGenrator {
	public boolean genrateKey(int len){
		if(len<=8){
			return true;
		}
		return false;
	}
}
