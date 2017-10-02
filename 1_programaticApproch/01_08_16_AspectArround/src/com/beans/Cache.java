package com.beans;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
	public Map<String, Object> dataMap = null;
	private static Cache instance=null;
	private Cache() {
		dataMap = new ConcurrentHashMap<String, Object>();
	}
	
	public synchronized static Cache getInstance(){
		
		if(instance==null){
			instance = new Cache();
		}
		return instance;
	} 
	
	public void put(String key,Object value){
		System.out.println("put value with "+key);
		dataMap.put(key, value);
	}
	public Object get(String key){
		System.out.println("get Value with Key : "+key);
		return dataMap.get(key);
	}
	public boolean containtsKey(String key){
		System.out.println("search key with "+key);
		return	dataMap.containsKey(key);
	}
}
