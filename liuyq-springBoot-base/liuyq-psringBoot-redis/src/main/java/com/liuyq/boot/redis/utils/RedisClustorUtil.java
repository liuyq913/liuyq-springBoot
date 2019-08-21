package com.liuyq.boot.redis.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liuyq.boot.redis.conf.RedisClusterConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

import java.math.BigDecimal;

/**
 * Created by liuyq on 2019/6/28.
 * 定义redis常规操作
 */
@Component
@EnableConfigurationProperties(RedisClusterConf.class) //读取配置对象
@ConditionalOnBean(JedisCluster.class)
public class RedisClustorUtil {
    @Autowired
    private JedisCluster jedisCluster;


    /////////////////////////////设值///////////////////////////////////////////////////////////

    /**
     * 这里只如果设置 Long类型BigDecimal 可能会掉精度
     *
     * @param key
     * @param value
     * @param <V>
     * @return
     */
    public <V> V set(String key, V value) {
        return execute(() -> {
            jedisCluster.set(key, JSONObject.toJSONString(value));
            return value;
        });
    }

    public BigDecimal setBigBecimal(String key, BigDecimal value) {
        return execute(() -> {
            jedisCluster.set(key, value.toPlainString());
            return value;
        });
    }

    public Long incr(String key) {
        return execute(() -> {
            return jedisCluster.incr(key);
        });
    }

    public boolean existes(String key) {
        return execute(() -> {
            return jedisCluster.exists(key);
        });
    }


    /////////////////////////////////////超时时间设值//////////////////////////////////////////////////

    /**
     * 带过期时间的设置
     *
     * @param key
     * @param value
     * @param seconds 超时时间
     * @return
     */
    public String setex(String key, String value, Integer seconds) {
        return execute(() -> {
            return jedisCluster.setex(key, seconds, value);
        });
    }

    /////////////////////////////////队列/////////////////////////////////////////////////
    public Long rpush(String key, String... value) {
        return execute(() -> jedisCluster.rpush(key, value));
    }

    public Long lpush(String key, String... value) {
        return execute(() -> jedisCluster.lpush(key, value));
    }

    public String rpop(String key) {
        return execute(() -> jedisCluster.rpop(key));
    }

    public Long lpop(String key, String... value) {
        return execute(() -> jedisCluster.lpush(key, value));
    }


    public <T> T getObject(String key, Class<T> clazz) {
        return execute(() -> {
            String jsonObject = jedisCluster.get(key);
            return JSON.parseObject(jsonObject, clazz);
        });
    }

    public <T> T execute(RedisFuntion<T> redisFuntion) {
        try {
            return redisFuntion.get();
        } catch (Exception e) {
            throw new RuntimeException("redis executor exception :" + e.getMessage());
        }
    }
}