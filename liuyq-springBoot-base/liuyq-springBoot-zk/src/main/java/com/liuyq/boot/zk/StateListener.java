package com.liuyq.boot.zk;

/**
 * @Auther: liuyuqing
 * @Date: 2020/1/17 17:39
 * @Description:
 */
public interface StateListener {
    int DISCONNECTED = 0;

    int CONNECTED = 1;

    int RECONNECTED = 2;

    void stateChanged(int connected);
}
