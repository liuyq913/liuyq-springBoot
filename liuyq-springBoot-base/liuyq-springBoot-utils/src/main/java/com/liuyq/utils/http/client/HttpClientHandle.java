package com.liuyq.utils.http.client;


import com.alibaba.fastjson.JSON;
import com.liuyq.utils.http.HttpConst;
import com.liuyq.utils.http.HttpHandle;
import com.liuyq.utils.http.HttpResult;
import com.liuyq.utils.http.ParameterConverter;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClientHandle implements HttpHandle {

	private final Logger logger  = LoggerFactory.getLogger(HttpClientHandle.class);
	
	@Override
	public HttpResult sendSSLGetRequest(String url, Map<String,String> textParams){
		return this.sendSSLGetRequest(url, null, textParams,null);
	}
	
	@Override
	public HttpResult sendSSLGetRequest(String url, Map<String,String> requestHeaders, Map<String,String> textParams , String decodeCharset){
		return this.sendGetRequest(url, requestHeaders, textParams, decodeCharset, true, true);
	}
	
	@Override
	public HttpResult sendGetRequest(String url, Map<String,String> textParams){
		return this.sendGetRequest(url, null, textParams,null, false, true);
	}
	
	@Override
	public HttpResult sendGetRequest(String url,Map<String,String> requestHeaders, Map<String,String> textParams ,String decodeCharset, boolean isSSL, boolean isNeedURLEncode){
		String responseContent = null;
		HttpClient httpClient = new DefaultHttpClient();
		int code = 0;
		try {
			if(isSSL){
				this.setSSL(httpClient);
	        }
			String query = ParameterConverter.convert2URL(textParams, isNeedURLEncode);
	        StringBuffer path = new StringBuffer();
	        path.append(url);
	        if (query != null && query.length() > 0){
	        	path.append("?" + query);
	        }
	        HttpGet httpGet = new HttpGet(path.toString());
	        this.setRequestHeader(requestHeaders, httpGet);
	        HttpResponse response = httpClient.execute(httpGet);
	        code = response.getStatusLine().getStatusCode();
	        
        	HttpEntity entity = response.getEntity();
        	if (null != entity) {
        		responseContent = EntityUtils.toString(entity, StringUtils.isBlank(decodeCharset) ? HttpConst.Charset.UTF_8 : decodeCharset);
        		EntityUtils.consume(entity);
        	}
		} catch (Exception e) {
			logger.error("与" + url + "通讯时发生异常", e);
		}
		return new HttpResult(code, responseContent);
	}
	
	@Override
	public HttpResult sendSSLPostRequest(String url, Map<String,String> bodyParams){
		return this.sendSSLPostRequest(url, null, bodyParams,null);
	}
	
	@Override
	public HttpResult sendSSLPostRequest(String url,Map<String,String> requestHeaders, Map<String,String> bodyParams ,String decodeCharset){
		return this.sendPostRequest(url, requestHeaders, bodyParams, decodeCharset, true);
	}
	
	@Override
	public HttpResult sendPostRequest(String url, Map<String,String> bodyParams){
		return this.sendPostRequest(url, null, bodyParams,null, false);
	}
	
	@Override
	public HttpResult sendPostRequest(String url,Map<String,String> requestHeaders, Map<String,String> bodyParams ,String decodeCharset, boolean isSSL){
		String responseContent = null;
		HttpClient httpClient = new DefaultHttpClient();
		int code = 0;
		try {
			if(isSSL) {
				this.setSSL(httpClient);
	        }
	        HttpPost post = new HttpPost(url);
        	this.setRequestHeader(requestHeaders, post);
        	List<BasicNameValuePair> valuePairs = ParameterConverter.convert2ValuePair(bodyParams);
        	if (valuePairs != null && valuePairs.size() > 0){
				post.setEntity(new UrlEncodedFormEntity(valuePairs, StringUtils.isBlank(decodeCharset) ? HttpConst.Charset.UTF_8 : decodeCharset));
        	}
        	HttpResponse response = httpClient.execute(post);
        	code = response.getStatusLine().getStatusCode();
        	HttpEntity entity = response.getEntity(); 
        	if (null != entity) {
        		responseContent = EntityUtils.toString(entity, StringUtils.isBlank(decodeCharset) ? HttpConst.Charset.UTF_8 : decodeCharset);
        		EntityUtils.consume(entity);
        	}
		} catch (Exception e) {
			logger.error("与" + url + "通讯时发生异常", e);
		}
		return new HttpResult(code, responseContent);
	}
	
	@Override
	public HttpResult sendSSLPostRequestWithXml(String url,String paramXmlStr){
		String responseContent = null;
		HttpClient httpClient = new DefaultHttpClient();
		int code = 0;
        HttpPost post = new HttpPost(url);
		try {
			setSSL(httpClient);
			//得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
	        StringEntity postEntity = new StringEntity(paramXmlStr, HttpConst.Charset.UTF_8);
	        post.addHeader(HttpConst.Header.CONTENT_TYPE, HttpConst.ContentType.XML);
	        post.setEntity(postEntity);
	        HttpResponse response = httpClient.execute(post);
        	code = response.getStatusLine().getStatusCode();
        	HttpEntity entity = response.getEntity();
        	responseContent = EntityUtils.toString(entity, HttpConst.Charset.UTF_8);
		} catch (Exception e) {
			logger.error("与"+url+"通讯时发生异常", e);
		}
		return new HttpResult(code, responseContent);
	}
	
	@Override
	public HttpResult sendSSLPostRequestWithJSON(String url, Object paramObj){
		return this.sendSSLPostRequestWithJSON(url, null, paramObj,null);
	}
	
	@Override
	public HttpResult sendSSLPostRequestWithJSON(String url,Map<String,String> requestHeaders, Object paramObj ,String decodeCharset){
		return this.sendPostRequestWithJSON(url, requestHeaders, paramObj, decodeCharset, true);
	}


	@Override
	public HttpResult sendPostRequestWithJSON(String url, Object paramObj){
		return this.sendPostRequestWithJSON(url, paramObj, 10000,10000);//默认10秒连接时间，10秒数据传输时间
	}

	@Override
	public HttpResult sendPostRequestWithJSON(String url, Object paramObj, int connectionTimeout, int sendDataTimeout) {
		return this.sendPostRequestWithJSON(url, null, paramObj,null, false,connectionTimeout,sendDataTimeout);
	}

	@Override
	public HttpResult sendPostRequestWithJSON(String url, Map<String, String> requestHeaders, Object paramObj, String decodeCharset, boolean isSSL) {
		return sendPostRequestWithJSON(url, requestHeaders, paramObj, decodeCharset, isSSL, 10000, 10000);
	}

	@Override
	public HttpResult sendPostRequestWithJSON(String url,Map<String,String> requestHeaders, Object paramObj ,String decodeCharset, boolean isSSL, int connectionTimeout, int sendDataTimeout){
		String responseContent = null;
		HttpClient httpClient = new DefaultHttpClient();
		httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,connectionTimeout);//连接时间
		httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,sendDataTimeout);//数据传输时间
		int code = 0;
		try {
			if(isSSL) {
				this.setSSL(httpClient);
	        }
	        HttpPost post = new HttpPost(url);
        	this.setRequestHeader(requestHeaders, post);
        	if (paramObj != null) {
				post.setEntity(this.paramObject2Json(paramObj, decodeCharset));//设置参数集
        	}
        	HttpResponse response = httpClient.execute(post);
        	code = response.getStatusLine().getStatusCode();
        	
        	HttpEntity entity = response.getEntity(); 
        	if (null != entity) {
        		responseContent = EntityUtils.toString(entity, StringUtils.isBlank(decodeCharset) ? HttpConst.Charset.UTF_8 : decodeCharset);
        		EntityUtils.consume(entity);
        	}
		} catch (Exception e) {
			logger.error("与" + url + "通讯时发生异常", e);
		}
		return new HttpResult(code, responseContent);
	}

	public HttpResult sendSSLPutRequest(String url, Map<String,String> bodyParams){
		return this.sendSSLPutRequest(url, null, bodyParams,null);
	}
	
	public HttpResult sendSSLPutRequest(String url,Map<String,String> requestHeaders, Map<String,String> bodyParams ,String decodeCharset){
		return this.sendPutRequest(url, requestHeaders, bodyParams, decodeCharset, true);
	}
	
	public HttpResult sendPutRequest(String url, Map<String,String> bodyParams){
		return this.sendPutRequest(url, null, bodyParams,null, false);
	}
	
	public HttpResult sendPutRequest(String url,Map<String,String> requestHeaders, Map<String,String> bodyParams ,String decodeCharset, boolean isSSL){
		String responseContent = null;
		HttpClient httpClient = new DefaultHttpClient();
		int code = 0;
		try {
			if(isSSL) {
				this.setSSL(httpClient);
	        }
	        HttpPut put = new HttpPut(url);
        	this.setRequestHeader(requestHeaders, put);
        	List<BasicNameValuePair> valuePairs = ParameterConverter.convert2ValuePair(bodyParams);
        	if (valuePairs != null && valuePairs.size() > 0) {
        		put.setEntity(new UrlEncodedFormEntity(valuePairs, StringUtils.isBlank(decodeCharset) ? HttpConst.Charset.UTF_8 : decodeCharset));
        	}
        	HttpResponse response = httpClient.execute(put);
        	code = response.getStatusLine().getStatusCode();
        	
        	HttpEntity entity = response.getEntity(); 
        	if (null != entity) {
        		responseContent = EntityUtils.toString(entity, StringUtils.isBlank(decodeCharset) ? HttpConst.Charset.UTF_8 : decodeCharset);
        		EntityUtils.consume(entity);
        	}
		} catch (Exception e) {
			logger.error("与" + url + "通讯时发生异常", e);
		}
		return new HttpResult(code, responseContent);
	}
	
	@Override
	public HttpResult sendSSLPutRequestWithJSON(String url, Object paramObj){
		return this.sendSSLPutRequestWithJSON(url, null, paramObj,null);
	}
	
	@Override
	public HttpResult sendSSLPutRequestWithJSON(String url,Map<String,String> requestHeaders, Object paramObj ,String decodeCharset){
		return this.sendPutRequestWithJSON(url, requestHeaders, paramObj, decodeCharset, true);
	}
	
	@Override
	public HttpResult sendPutRequestWithJSON(String url, Object paramObj){
		return this.sendPutRequestWithJSON(url, null, paramObj,null, false);
	}
	
	@Override
	public HttpResult sendPutRequestWithJSON(String url,Map<String,String> requestHeaders, Object paramObj ,String decodeCharset, boolean isSSL){
		String responseContent = null;
		HttpClient httpClient = new DefaultHttpClient();
		int code = 0;
		try {
			if(isSSL){
				this.setSSL(httpClient);
	        }
			HttpPut put = new HttpPut(url);
        	this.setRequestHeader(requestHeaders, put);
        	if (paramObj != null){
				put.setEntity(this.paramObject2Json(paramObj, decodeCharset));//设置参数集
        	}
        	HttpResponse response = httpClient.execute(put);
        	code = response.getStatusLine().getStatusCode();
        	
        	HttpEntity entity = response.getEntity(); 
        	if (null != entity) {
        		responseContent = EntityUtils.toString(entity, StringUtils.isBlank(decodeCharset) ? HttpConst.Charset.UTF_8 : decodeCharset);
        		EntityUtils.consume(entity);
        	}
		} catch (Exception e) {
			logger.error("与" + url + "通讯时发生异常", e);
		}
		return new HttpResult(code, responseContent);
	}
	
	private void setSSL(HttpClient httpClient) throws NoSuchAlgorithmException, KeyManagementException {
		
		X509TrustManager x509TrustManager = new X509TrustManager() {
    		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    		}
    		
    		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    		}
    		
    		public X509Certificate[] getAcceptedIssuers() {
    			return null;
    		}
    	};
    	
    	SSLContext sslContext = SSLContext.getInstance(HttpConst.Https.PROTOCOL);
    	sslContext.init(null, new TrustManager[] { x509TrustManager }, null);
		SSLSocketFactory socketFactory = new SSLSocketFactory(sslContext);
		socketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme(HttpConst.Https.SCHEME, HttpConst.Https.DEFAULT_PORT, socketFactory));
	}
	
	private void setRequestHeader(Map<String, String> requestHeaders, HttpRequest request){
		if (requestHeaders != null && requestHeaders.size() > 0) {
			for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
				request.addHeader(entry.getKey(), entry.getValue());
			}
		}
	}

	/**
	 * 将参数集转为json
	 * @param paramObj
	 * @param decodeCharset
     * @return
     */
	private StringEntity paramObject2Json(Object paramObj, String decodeCharset){
		Object jsonObj = JSON.toJSON(paramObj);//将参数集转为json
		StringEntity stringEntity = null;
		stringEntity = new StringEntity(jsonObj.toString(), StringUtils.isBlank(decodeCharset) ? HttpConst.Charset.UTF_8 : decodeCharset);
		stringEntity.setContentEncoding(StringUtils.isBlank(decodeCharset) ? HttpConst.Charset.UTF_8 : decodeCharset);
		stringEntity.setContentType(HttpConst.ContentType.JSON);//设置Content-type
		return stringEntity;
	}

	/**
	 * 获取客户端请求参数中所有的信息
	 * @param request
	 * @return
	 */
	public Map<String, String> getAllRequestParam(final HttpServletRequest request) {
		Map<String, String> res = new HashMap<String, String>();
		Enumeration<?> temp = request.getParameterNames();
		if (null != temp) {
			while (temp.hasMoreElements()) {
				String en = (String) temp.nextElement();
				String value = request.getParameter(en);
				res.put(en, value);
				//如果字段的值为空，判断若值为空，则删除这个字段>
				if (null == res.get(en) || "".equals(res.get(en))) {
					res.remove(en);
				}
			}
		}
		return res;
	}

	/**
	 * 获取当前请求的IP,对使用代理后都有效
	 * @return
	 */
	public String getRequestIP(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
