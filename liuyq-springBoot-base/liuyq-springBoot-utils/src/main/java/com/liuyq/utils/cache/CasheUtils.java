package com.liuyq.utils.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liuyq on 2019/6/13.
 * 本地缓存工具类
 */
public class CasheUtils {
    private static final Logger log = LoggerFactory.getLogger(CasheUtils.class);

    // 毫秒
    public static final long M_SEND_20 = 20 * 1000;
    public static final long M_SEND_30 = 30 * 1000;
    public static final long M_MINU_1 = 60 * 1000;
    public static final long M_MINU_2 = 2 * 60 * 1000;
    public static final long M_MINU_5 = 5 * 60 * 1000;
    public static final long M_MINU_10 = 10 * 60 * 1000;
    public static final long M_MINU_30 = 30 * 60 * 1000;
    public static final long M_MINU_60 = 60 * 60 * 1000;
    public static final long M_DAY_1 = 24L * 3600L * 1000L;
    public static final long M_DAY_7 = 7L * 24L * 3600L * 1000L;
    // 秒
    public static final int S_MINU_5 = (int) (M_MINU_5 / 1000L);
    public static final int S_DAY_1 = (int) (M_DAY_1 / 1000L);
    public static final int S_DAY_7 = (int) (M_DAY_7 / 1000L);


    /**
     * 缓存池
     */
    private static final Map<String, Cashe> CASHE_MAP = new ConcurrentHashMap<>();
}
