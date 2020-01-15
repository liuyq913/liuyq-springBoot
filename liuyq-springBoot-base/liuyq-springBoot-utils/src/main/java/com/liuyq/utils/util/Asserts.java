package com.liuyq.utils.util;


import com.liuyq.utils.exception.BussinessException;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

/**
 * 断言工具，抛出{@  BussinessException}异常
 *
 * @author liuyq 2018/11/26 11:02 AM
 * @see BussinessException
 */
public class Asserts {

    //region string-------------------------------------------------------------

    /**
     * 断言字符串不为空白
     *
     * @param value 校验字符串
     * @param msg   错误信息
     * @throws BussinessException 异常对象
     */
    public static void notBlank(String value, String msg) throws BussinessException {

        if (StringUtils.isBlank(value)) {
            throw new BussinessException(msg);
        }
    }

    /**
     * 断言字符串不为空
     *
     * @param str 校验字符串
     * @param msg 错误信息
     * @throws BussinessException
     */
    public static void notEmpty(String str, String msg) throws BussinessException {
        if (StringUtils.isEmpty(str)) {
            throw new BussinessException(msg);
        }
    }
    //endregion string-------------------------------------------------------------

    //region collection and array-----------------------------------------------

    /**
     * 断言集合不为空
     *
     * @param col 校验集合
     * @param msg 错误信息
     * @throws BussinessException
     */
    public static void notEmpty(Collection col, String msg) throws BussinessException {
        if (CollectionUtils.isEmpty(col)) {
            throw new BussinessException(msg);
        }
    }

    /**
     * 断言map不为空
     *
     * @param map 校验集合
     * @param msg 错误信息
     * @throws BussinessException
     */
    public static void notEmpty(Map<?, ?> map, String msg) throws BussinessException{
        if (MapUtils.isEmpty(map)) {
            throw new BussinessException(msg);
        }
    }

    /**
     * 断言集合不为空
     *
     * @param arr 校验集合
     * @param msg 错误信息
     * @throws BussinessException
     */
    public static void notEmpty(Object[] arr, String msg) throws BussinessException {
        if (ArrayUtils.isEmpty(arr)) {
            throw new BussinessException(msg);
        }
    }

    /**
     * 断言集合中没有重复元素
     *
     * @param col 校验集合
     * @param msg 错误信息
     * @throws BussinessException
     */
    public static void isDistinct(Collection col, String msg) throws BussinessException {
        if (CollectionUtils.isEmpty(col)) {
            return;
        }
        if (new HashSet<Object>(col).size() != col.size()) {
            throw new BussinessException(msg);
        }
    }
    //endregion collection and array-----------------------------------------------

    //region bool---------------------------------------------------------------

    /**
     * 断言参数为true
     *
     * @param value 校验布尔值
     * @param msg   错误信息
     * @throws BussinessException 异常对象
     */
    public static void isTrue(boolean value, String msg) throws BussinessException {

        if (!value) {
            throw new BussinessException(msg);
        }
    }

    /**
     * 断言参数为false
     *
     * @param value 校验布尔值
     * @param msg   错误信息
     * @throws BussinessException 异常对象
     */
    public static void isFalse(boolean value, String msg) throws BussinessException {

        if (value) {
            throw new BussinessException(msg);
        }
    }
    //endregion bool---------------------------------------------------------------

    //region object-------------------------------------------------------------

    /**
     * 断言对象为空
     *
     * @param obj 校验对象
     * @param msg 错误信息
     * @throws BussinessException 异常对象
     */
    public static void isNull(Object obj, String msg) throws BussinessException {

        if (null != obj) {
            throw new BussinessException(msg);
        }
    }

    /**
     * 断言对象不为空
     *
     * @param obj 校验对象
     * @param msg 错误信息
     * @throws BussinessException 异常对象
     */
    public static void notNull(Object obj, String msg) throws BussinessException {

        if (null == obj) {
            throw new BussinessException(msg);
        }
    }

    /**
     * 断言给出的两个参数equal为true
     *
     * @param obj      -第一个参数
     * @param otherObj -另一个参数
     * @param -错误码
     * @param msg      -错误信息
     * @throws BussinessException 异常对象
     */
    public static void isEqual(Object obj, Object otherObj, String msg) throws BussinessException {
        if (!Objects.equals(obj, otherObj)) {
            throw new BussinessException(msg);
        }
    }

    /**
     * 断言给出的两个参数equal为false
     *
     * @param obj      -第一个参数
     * @param otherObj -另一个参数
     * @param -错误码
     * @param msg      -错误信息
     * @throws BussinessException 异常对象
     */
    public static void notEqual(Object obj, Object otherObj, String msg) throws BussinessException {
        if (Objects.equals(obj, otherObj)) {
            throw new BussinessException(msg);
        }
    }
    //endregion object-------------------------------------------------------------

    //region number-------------------------------------------------------------

    /**
     * 断言参数为0
     *
     * @param value 校验参数，支持类型：Integer、Long、Float、Double、BigDecimal、Short、Byte
     * @param msg   错误信息
     * @throws BussinessException 异常对象
     */
    public static void isZero(Object value, String msg) throws BussinessException {
        boolean isTrue = false;

        if (value instanceof Integer) {
            isTrue = (int) value == 0;
        } else if (value instanceof Long) {
            isTrue = (Long) value == 0;
        } else if (value instanceof Float) {
            isTrue = (Float) value == 0;
        } else if (value instanceof Double) {
            isTrue = (Double) value == 0;
        } else if (value instanceof BigDecimal) {
            isTrue = BigDecimal.ZERO.compareTo((BigDecimal) value) == 0;
        } else if (value instanceof Short) {
            isTrue = (Short) value == 0;
        } else if (value instanceof Byte) {
            isTrue = (Byte) value == 0;
        }

        if (!isTrue) {
            throw new BussinessException(msg);
        }
    }

    /**
     * 断言参数不为0
     *
     * @param value 校验参数，支持类型：Integer、Long、Float、Double、BigDecimal、Short、Byte
     * @param msg   错误信息
     * @throws BussinessException 异常对象
     */
    public static void notZero(Object value, String msg) throws BussinessException {
        boolean isTrue = false;

        if (value instanceof Integer) {
            isTrue = (int) value != 0;
        } else if (value instanceof Long) {
            isTrue = (Long) value != 0;
        } else if (value instanceof Float) {
            isTrue = (Float) value != 0;
        } else if (value instanceof Double) {
            isTrue = (Double) value != 0;
        } else if (value instanceof BigDecimal) {
            isTrue = BigDecimal.ZERO.compareTo((BigDecimal) value) != 0;
        } else if (value instanceof Short) {
            isTrue = (Short) value != 0;
        } else if (value instanceof Byte) {
            isTrue = (Byte) value != 0;
        }

        if (!isTrue) {
            throw new BussinessException(msg);
        }
    }

    /**
     * 断言参数小于0
     *
     * @param value 校验参数，支持类型：Integer、Long、Float、Double、BigDecimal、Short、Byte
     * @param msg   错误信息
     * @throws BussinessException 异常对象
     */
    public static void isLessThanZero(Object value, String msg) throws BussinessException {
        boolean isTrue = false;

        if (value instanceof Integer) {
            isTrue = (int) value < 0;
        } else if (value instanceof Long) {
            isTrue = (Long) value < 0;
        } else if (value instanceof Float) {
            isTrue = (Float) value < 0;
        } else if (value instanceof Double) {
            isTrue = (Double) value < 0;
        } else if (value instanceof BigDecimal) {
            isTrue = BigDecimal.ZERO.compareTo((BigDecimal) value) > 0;
        } else if (value instanceof Short) {
            isTrue = (Short) value < 0;
        } else if (value instanceof Byte) {
            isTrue = (Byte) value < 0;
        }

        if (!isTrue) {
            throw new BussinessException(msg);
        }
    }

    /**
     * 断言参数大于0
     *
     * @param value 校验参数，支持类型：Integer、Long、Float、Double、BigDecimal、Short、Byte
     * @param msg   错误信息
     * @throws BussinessException 异常对象
     */
    public static void isGreaterThanZero(Object value, String msg) throws BussinessException {
        boolean isTrue = false;

        if (value instanceof Integer) {
            isTrue = (int) value > 0;
        } else if (value instanceof Long) {
            isTrue = (Long) value > 0;
        } else if (value instanceof Float) {
            isTrue = (Float) value > 0;
        } else if (value instanceof Double) {
            isTrue = (Double) value > 0;
        } else if (value instanceof BigDecimal) {
            isTrue = BigDecimal.ZERO.compareTo((BigDecimal) value) < 0;
        } else if (value instanceof Short) {
            isTrue = (Short) value > 0;
        } else if (value instanceof Byte) {
            isTrue = (Byte) value > 0;
        }

        if (!isTrue) {
            throw new BussinessException(msg);
        }
    }

    /**
     * 断言参数是1
     *
     * @param value 校验参数，支持类型：Integer、Long、Float、Double、BigDecimal、Short、Byte
     * @param msg   错误信息
     * @throws BussinessException 异常对象
     */
    public static void isOne(Object value, String msg) throws BussinessException {
        boolean isTrue = false;

        if (value instanceof Integer) {
            isTrue = (int) value == 1;
        } else if (value instanceof Long) {
            isTrue = (Long) value == 1;
        } else if (value instanceof Float) {
            isTrue = (Float) value == 1;
        } else if (value instanceof Double) {
            isTrue = (Double) value == 1;
        } else if (value instanceof BigDecimal) {
            isTrue = BigDecimal.ONE.compareTo((BigDecimal) value) == 0;
        } else if (value instanceof Short) {
            isTrue = (Short) value == 1;
        } else if (value instanceof Byte) {
            isTrue = (Byte) value == 1;
        }

        if (!isTrue) {
            throw new BussinessException(msg);
        }
    }
    //endregion number-------------------------------------------------------------

}
