package com.aa.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.InitializingBean;

public class Cache implements InitializingBean {
	private Map<String, Object> dataMap = null;

	@Override
	public void afterPropertiesSet() throws Exception {
		dataMap = new ConcurrentHashMap<String, Object>();

	}

	public boolean ContainsKey(String key) {
		if (dataMap.containsKey(key)) {
			return true;
		}
		return false;
	}

	public Object get(String key) {
		return dataMap.get(key);
	}

	public void put(String key, Object value) {
		dataMap.put(key, value);
	}

}
