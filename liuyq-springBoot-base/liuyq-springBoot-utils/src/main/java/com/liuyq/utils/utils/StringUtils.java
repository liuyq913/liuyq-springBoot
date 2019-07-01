package com.liuyq.utils.utils;

import java.util.*;

/**
 * @author pudding
 * @version 0.1.0
 * @design
 * @date 2019/2/27.20:46
 * @see
 */
public class StringUtils {

    private StringBuilder stringBuilder;

    public StringUtils(String string) {
        if (string == null) this.stringBuilder = new StringBuilder();
        else this.stringBuilder = new StringBuilder(string);
    }

    public StringUtils(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public static String[] toArray(String src, String interval) {
        if (src == null || interval == null) return null;
        int start  = 0, idx, ilen = interval.length();
        List<String> result = new LinkedList<>();
        while ((idx = src.indexOf(interval, start)) > -1) {
            if (idx > start) result.add(src.substring(start, idx));
            start = idx + ilen;
        }
        if (start < src.length()) result.add(src.substring(start));
        return result.toArray(new String[result.size()]);
    }

    public static List<String> toList(String src, String interval) {
        if (src == null || interval == null) return null;
        int start  = 0, idx, ilen = interval.length();
        List<String> result = new LinkedList<>();
        while ((idx = src.indexOf(interval, start)) > -1) {
            if (idx > start) result.add(src.substring(start, idx));
            start = idx + ilen;
        }
        if (start < src.length()) result.add(src.substring(start));
        return result;
    }

    public static String[] distinct(String[] src) {
        if (src == null || src.length == 1) return src;
        Set<String> set = new HashSet<>();
        for (String s : src) set.add(s);
        return set.toArray(new String[set.size()]);
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if(! Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }

    /**
     * 随机数字字符串
     * @param len
     * @return
     */
    public static String randomNumStr(int len) {
        char[] randoms = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random random = new Random();
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < len; i++)
            ret.append(randoms[random.nextInt(randoms.length)]);

        return ret.toString();
    }

    public static String[] posValues = {"", "0", "00", "000", "0000", "00000"};

    public static String covertPos(long num) {
        String value = num + "";
        return posValues[6 - value.length()] + value;
    }

    /**
     * 如果src的length()小于size，则可以在补指定的位
     * @param src
     * @param prefix
     * @param size
     * @return
     */
    public static String addPrefix(String src, String prefix, int size) {
        if (src.length() >= size) return src;
        int num = (size - src.length()) / prefix.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num; i++) builder.append(prefix);
        return builder.append(src).toString();
    }

    // append  ///

    /**
     * 排除null值
     * @param value
     * @return
     */
    public static StringUtils appendNew(String value) {
        if (value != null) return new StringUtils(new StringBuilder(value));
        return new StringUtils(new StringBuilder());
    }

    public StringUtils append(String value) {
        if (value != null) stringBuilder.append(value);
        return this;
    }

    public <T> StringUtils append(String prefix, T value, String suffix) {
        if (value != null)
            stringBuilder.append(prefix).append(value).append(suffix);
        return this;
    }

    public String appendValue() {
        return stringBuilder.toString();
    }

}
