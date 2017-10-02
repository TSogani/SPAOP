package com.aa.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
	private static Cache instance;
	private Map<String , Object> dataMap ;

	private Cache() {
		// no opperation
		dataMap = new ConcurrentHashMap<String , Object>();
	}

	public static synchronized Cache getInstance() {
		if (instance == null) {
			instance = new Cache();
			return instance;
		}
		return instance;
	}

	public Object get(String key){
		System.out.println("searching..."+key);
		return dataMap.get(key);
	}
	public boolean cantainsKey(String key){
		return dataMap.containsKey(key);
	}
	public Object put(String key,Object value){
		System.out.println("Put key into cache..."+key+" : "+value);
		return dataMap.put(key, value);
	}
}
