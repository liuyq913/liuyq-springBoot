package com.liuyq.boot.redis.conf;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by liuyq on 2019/6/28.
 * RedisUtil配置类，生成 JedisCluster
 */

@ConfigurationProperties(prefix = "liuyq.redis")
@Configuration
@Data
public class RedisClusterConf {

    /**
     * redis地址和端口 127.0.0.1：6379,127.0.0.1：6381,127.0.0.1：6382
     */
    private String hosts;
    /**
     * pool中持有最大对象数
     */
    private String maxTotal;
    /**
     * 获取redis对象的timeout时间
     */
    private String timeout;
    /**
     * 最大空闲对象数
     */
    private String maxIdle;

    private JedisPoolConfig jedisPoolConfig;

    private volatile Map<String, Integer> hostAndPortMap = null;


    /**
     * 拆分host （集群方式）
     *
     * @return
     */
    public Map<String, Integer> getHostAndPort() {
        if (null == hostAndPortMap) {
            synchronized (this) { //是用当前类的class对象加锁
                //这里比如两个线程A B，线程A进来之后，构造了hostAndPortMap，然后返回，这个时候线程B也进来了，那么由于没有判断hostAndPortMap为null，
                // 那么就回出现hostAndPortMa初始化两次的现象
                if (null == hostAndPortMap) {
                    if (!StringUtils.isEmpty(hosts)) {
                        hostAndPortMap = new HashMap<>();
                        if (hosts.contains(",")) {
                            com.liuyq.utils.utils.StringUtils.toList(hosts, ",").stream()
                                    .map(t -> t.split(":")).forEach(e -> hostAndPortMap.put(e[0], new Integer(e[1])));
                        } else {
                            String[] split = hosts.split(":");
                            hostAndPortMap.put(split[0], new Integer(split[1]));
                        }
                    }
                }
                if (jedisPoolConfig == null) {
                    /**
                     *设置最大持有对象数和最大空闲对象数
                     */
                    this.jedisPoolConfig = new JedisPoolConfig();
                    this.jedisPoolConfig.setMaxTotal(new Integer(maxTotal));
                    this.jedisPoolConfig.setMaxIdle(new Integer(maxIdle));
                }

            }
        }
        return hostAndPortMap;
    }

    public Set<HostAndPort> getHostAndPost() {
        Set<HostAndPort> hostAndPorts = new HashSet<>();
        Map<String, Integer> hostAndPort = this.getHostAndPort();
        if (CollectionUtils.isEmpty(hostAndPort)) return null;
        hostAndPort.forEach((k, v) -> hostAndPorts.add(new HostAndPort(k, v)));
        return hostAndPorts;
    }

    /**
     * 构造JedisCluster
     */
    @Bean
    public JedisCluster buildJedisCluster() {Set<HostAndPort> hostAndPorts = getHostAndPost();
        if (null == hostAndPorts) throw new NullPointerException("hostAndPorts is null");
        return new JedisCluster(hostAndPorts, new Integer(timeout), jedisPoolConfig);
    }
}
