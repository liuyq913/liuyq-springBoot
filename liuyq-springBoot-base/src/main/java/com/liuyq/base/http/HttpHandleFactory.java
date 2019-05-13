package com.liuyq.base.http;


import com.liuyq.base.http.client.HttpClientHandle;

public class HttpHandleFactory {
	
	public static HttpHandle getDefaultHandle() {
		try {
			Class.forName("org.apache.http.client.HttpClient");
			return new HttpClientHandle();
		} catch (Exception e) {
		}
		return null;
	}
	
}
