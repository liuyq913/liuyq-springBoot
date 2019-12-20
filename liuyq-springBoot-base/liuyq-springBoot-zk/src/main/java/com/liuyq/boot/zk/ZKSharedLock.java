package com.liuyq.boot.zk;

import com.liuyq.utils.lock.DistributedLock;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * zookeeper不可重入锁
 */
public class ZKSharedLock implements DistributedLock {

    private static Logger logger = LoggerFactory.getLogger(ZKSharedLock.class);

    private CuratorFramework client;

    @Override
    public boolean tryLock(String path) {
        if (client == null) {
            return false;
        }
        InterProcessLock lock = new InterProcessSemaphoreMutex(client, path);
        try {
            lock.acquire();
            logger.info("get lock success! key = {}", path);
            return true;
        } catch (Exception e) {
            logger.error("acquire lock error! key={}", path, e);
        }
        return false;
    }

    @Override
    public boolean tryLock(String path, int time) {
        if (client == null) {
            return false;
        }
        InterProcessLock lock = new InterProcessSemaphoreMutex(client, path);
        try {
            boolean ret = lock.acquire(time, TimeUnit.SECONDS);
            logger.info("get lock {}! key = {}", ret, path);
            return ret;
        } catch (Exception e) {
            logger.error("acquire lock error! key={}", path, e);
        }
        return false;
    }

    @Override
    public boolean unLock(String path) {
        if (client == null) {
            return false;
        }
        InterProcessLock lock = new InterProcessSemaphoreMutex(client, path);
        try {
            if (lock.isAcquiredInThisProcess()) {
                lock.release();
                return true;
            }
            logger.info("release {} lock success!", path);
        } catch (Exception e) {
            logger.error("release lock error! key={}", path, e);
        }
        return false;
    }

    @Override
    public boolean tryLockInTime(String key, int time) {
        return false;
    }


    public void setClient(CuratorFramework client) {
        this.client = client;
    }
}
