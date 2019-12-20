package com.liuyq.utils.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletData {

    private HttpServletRequest request;

    private HttpServletResponse response;

    private long time;

    /**
     * 服务端内部设置的值。区分 壳、PC、mobile。
     * see SessionConstant#DEVICES
     */
    private String deviceType;

    /**
     * 当前客户端版本号
     */
    private String version;
    /**
     * 当前客户端的平台，前端传在Header中的值。web、Android、iOS。
     */
    private String platform;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
