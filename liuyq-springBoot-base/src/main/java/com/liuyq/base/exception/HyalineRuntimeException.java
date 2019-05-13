/**
 * HyalineRuntimeException.java
 * Created at 2016-03-01
 * Created by wangkang
 * Copyright (C) 2016 itkk.org, All rights reserved.
 */
package com.liuyq.base.exception;

/**
 * <p>
 * ClassName: HyalineRuntimeException
 * </p>
 * <p>
 * Description: 系统运行时异常
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2016年3月23日
 * </p>
 */
public class HyalineRuntimeException extends RuntimeException {

    /**
     * <p>
     * Field serialVersionUID: 序列号
     * </p>
     */
    private static final long serialVersionUID = 1L;

    /**
     * <p>
     * Description: 构造函数
     * </p>
     *
     * @param message 异常信息
     */
    public HyalineRuntimeException(String message) {
        super(message);
    }

    /**
     * <p>
     * Description: 构造函数
     * </p>
     *
     * @param cause 堆栈
     */
    public HyalineRuntimeException(Throwable cause) {
        super(cause);
    }

    /**
     * <p>
     * Description: 构造函数
     * </p>
     *
     * @param message 异常信息
     * @param cause   堆栈
     */
    public HyalineRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}
