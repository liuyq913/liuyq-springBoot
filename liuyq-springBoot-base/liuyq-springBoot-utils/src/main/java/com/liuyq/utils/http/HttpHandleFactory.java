package com.liuyq.utils.http;


import com.liuyq.utils.http.client.HttpClientHandle;

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
