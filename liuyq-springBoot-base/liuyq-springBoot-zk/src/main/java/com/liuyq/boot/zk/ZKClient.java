package com.liuyq.boot.zk;

import java.util.List;

/**
 * @Auther: liuyuqing
 * @Date: 2020/1/17 16:47
 * @Description: zk基本操作
 */
public interface ZKClient {
    /**
     * 创建节点
     * @param path 路径
     * @param ephemeral 是否临时节点， true 会创建持久节点
     */
    void create(String path, boolean ephemeral);

    void delete(String path) throws Exception;

    List<String> getChildren(String path) throws Exception;

    boolean isConnected();

    void close();
}

