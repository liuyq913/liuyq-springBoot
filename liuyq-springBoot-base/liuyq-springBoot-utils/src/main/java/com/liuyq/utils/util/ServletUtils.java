package com.liuyq.utils.util;

import com.liuyq.utils.exception.BussinessException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ServletUtils {

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    /**
     * 通过流回写数据
     * */
    public static void write(String str) throws Exception{
        try {
            getResponse().getOutputStream().write(str.getBytes("UTF-8"));
        } catch (IOException e) {
          throw new BussinessException("写入io数据出错");
        }
    }
}
