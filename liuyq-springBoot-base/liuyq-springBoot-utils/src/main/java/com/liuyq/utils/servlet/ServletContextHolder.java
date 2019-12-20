package com.liuyq.utils.servlet;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 保存servlet 相关对象
 *
 * @author ChenJunhui
 */
public class ServletContextHolder {

    public static final String[] IP_HEADERS = new String[]{"Rpc-Client-IP", "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR"};
    private static final ThreadLocal<ServletData> manager = new ThreadLocal<ServletData>();

    public static String getIp() {
        return getIp(getRequest());
    }

    public static String getIp(HttpServletRequest request) {
        try {
            if (request == null) {
                return null;
            } else {
                String[] ip = IP_HEADERS;
                int var2 = ip.length;

                for (int var3 = 0; var3 < var2; ++var3) {
                    String header = ip[var3];
                    String ip1 = request.getHeader(header);
                    if (ip1 != null && ip1.length() >= 7 && !"unknown".equalsIgnoreCase(ip1)) {
                        return ip1;
                    }
                }

                String var6 = request.getRemoteAddr();
                return var6;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static void prepare(HttpServletRequest request, HttpServletResponse response) {
        ServletData sd = new ServletData();
        sd.setRequest(request);
        sd.setResponse(response);
        sd.setTime(System.currentTimeMillis());
        manager.set(sd);
    }

    public static void prepare(HttpServletRequest request, HttpServletResponse response, String deviceType) {
        ServletData sd = new ServletData();
        sd.setRequest(request);
        sd.setResponse(response);
        sd.setTime(System.currentTimeMillis());
        sd.setDeviceType(deviceType);
        manager.set(sd);
    }

    /**
     * 获取request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        return manager.get().getRequest();
    }

    /**
     * 获取response
     *
     * @return
     */
    public static HttpServletResponse getResponse() {
        return manager.get().getResponse();
    }

    /**
     * 获取session
     *
     * @return
     */
    public static HttpSession getSession() {
        if (manager.get() == null || manager.get().getRequest() == null) {
            return null;
        }
        return manager.get().getRequest().getSession();
    }

    /**
     * 获取servletContext
     *
     * @return
     */
    public static ServletContext getServletContext() {
        return manager.get().getRequest().getSession().getServletContext();
    }

    public static String getUserAgent() {
        return manager.get().getRequest().getHeader("user-agent");
    }

    public static void clear() {
        manager.remove();
    }

    public static ServletData getServletData() {
        return manager.get();
    }

    /**
     * 获取设备类型，参考SessionConstant
     *
     * @return
     */
    public static String getDeviceType() {
        return manager.get().getDeviceType();
    }

    public static String getParam(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        try {
            if (getRequest() == null) {
                return null;
            }
            return getRequest().getParameter(key);
        } catch (Exception e) {
            return null;
        }
    }
}
