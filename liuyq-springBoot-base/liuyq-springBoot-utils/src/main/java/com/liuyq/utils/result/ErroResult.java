package com.liuyq.utils.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @author L.C
 * @version 0.0.1
 * @date 2017/10/23
 * @time 下午2:35
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 */
public class ErroResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private String type;

    private String message;

    @JsonIgnoreProperties
    private Throwable throwable;

    public ErroResult(){}

    public ErroResult(Throwable e){
        this.type = e.getClass().getName();
        this.message = e.getMessage();
        this.throwable = e;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
