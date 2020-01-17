package com.liuyq.boot.zk;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Auther: liuyuqing
 * @Date: 2020/1/17 16:54
 * @Description:
 */
public abstract class AbstractZKClient implements ZKClient {
    private final Set<StateListener> stateListeners = new CopyOnWriteArraySet<StateListener>();
    private volatile boolean closed = false;

    public Set<StateListener> getSessionListeners() {
        return stateListeners;
    }

    protected void stateChanged(int state) {
        for (StateListener sessionListener : getSessionListeners()) {
            sessionListener.stateChanged(state);
        }
    }

    public void close(){
        if(closed) return;
        closed = true;
        try {
            doClose();
        } catch (Throwable t) {

        }
    }

    //创建持久节点
    protected abstract void createPersistent(String path);

    //创建临时节点
    protected abstract void createEphemeral(String path);

    protected abstract void createPersistent(String path, String data);

    protected abstract void createEphemeral(String path, String data);

    protected abstract boolean checkExists(String path);

    protected abstract void doClose();

}
