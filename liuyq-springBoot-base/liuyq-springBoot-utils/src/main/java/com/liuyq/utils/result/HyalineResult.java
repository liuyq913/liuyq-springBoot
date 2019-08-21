package com.liuyq.utils.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author L.C
 * @version 0.0.1
 * @date 2017/10/20
 * @time 上午12:28
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 */
@Data
public class HyalineResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code = 0; //默认是成功的

    private String message = "成功";

    private T object;

    private ErroResult erroResult;

    public HyalineResult() {
    }

    public HyalineResult(T resultBody){
        this.object = resultBody;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getObject() {
        return object;
    }

    public ErroResult getErroResult() {
        return erroResult;
    }

    public static <T> HyalineResult<T> success(Integer code, T object) {
        HyalineResult<T> hyalineResult = new HyalineResult();
        hyalineResult.code = code;
        hyalineResult.setSuccess(object);
        return hyalineResult;
    }

    public static <T> HyalineResult<T> success(T object) {
        HyalineResult<T> hyalineResult = new HyalineResult();
        hyalineResult.setSuccess(object);
        return hyalineResult;
    }

    public static HyalineResult success() {
        HyalineResult hyalineResult = new HyalineResult();
        hyalineResult.message = "成功!";
        return hyalineResult;
    }

    public static <T> HyalineResult<T> error(Integer code, Throwable e) {
        HyalineResult<T> hyalineResult = new HyalineResult();
        hyalineResult.setError(code, e);
        return hyalineResult;
    }

    public static <T> HyalineResult<T> error(Integer code, String message) {
        HyalineResult<T> hyalineResult = new HyalineResult();
        hyalineResult.code = code;
        hyalineResult.message = message;
        return hyalineResult;
    }

    public void setSuccess(T object) {
        this.message = "成功!";
        this.object = object;
    }


    public void setError(Integer code, Throwable e) {
        this.message = e.getMessage();
        this.erroResult = new ErroResult(e);
    }

    @Override
    public String toString() {
        return "HyalineResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", object=" + object +
                ", erroResult=" + erroResult +
                '}';
    }

    /**
     * 基本的CODE码
     */
    public static class ErrorBaseCode {

        public static final Integer PARAMEERROR = 1001; //

        public static final Integer ORTHERERROR = 99999; //


    }

}
