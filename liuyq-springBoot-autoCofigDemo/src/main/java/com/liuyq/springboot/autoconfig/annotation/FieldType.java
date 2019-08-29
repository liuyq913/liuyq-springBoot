package com.liuyq.springboot.autoconfig.annotation;

import java.lang.annotation.*;

/**
 * @author luosen
 * @version 0.0.1
 * @date 2019/8/28
 * @time 14:04
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldType {

    /**
     * 字段类型
     */
    String type() default "N";

    /**
     * 字段长度
     */
    int length() default 0;

    /**
     * 顺序
     */
    int sort() default 0;
}
