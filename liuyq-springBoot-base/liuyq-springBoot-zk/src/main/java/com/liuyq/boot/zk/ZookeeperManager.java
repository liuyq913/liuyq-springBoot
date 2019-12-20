package com.liuyq.boot.zk;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

/**
 * zookeeper 节点 管理 基于 curator
 * the spring config is
 * <bean id="retryPolicy" class="org.apache.curator.retry.ExponentialBackoffRetry">
 * <constructor-arg index="0" value="1000" />
 * <constructor-arg index="1" value="3" />
 * </bean>
 * <p>
 * <bean id="curatorClient" class="org.apache.curator.framework.CuratorFrameworkFactory" factory-method="newClient" init-method="start">
 * <constructor-arg index="0" value="192.168.1.79:2181" />
 * <constructor-arg index="1" value="10000" />
 * <constructor-arg index="2" value="10000" />
 * <constructor-arg index="3" ref="retryPolicy" />
 * </bean>
 * <p>
 * <bean id="zookeeperManager" class="org.codemonkey.zookeeper.ZookeeperManager">
 * <property name="curatorClient" ref="curatorClient"></property>
 * <property name="initPersistentPaths">
 * <list>
 * <value>/imservers</value>
 * </list>
 * </property>
 * </bean>
 *
 * @author liuyq
 * @Description: zk 节点操作
 */
public class ZookeeperManager implements InitializingBean, DisposableBean {

    public static final String SPLIT = "/";

    private static Logger logger = LoggerFactory.getLogger(ZookeeperManager.class);

    private CuratorFramework curatorClient;

    private List<String> initPersistentPaths; //初始化的时候创建的一些持久化节点

    @Override
    public void afterPropertiesSet() throws Exception {
        curatorClient.getConnectionStateListenable().addListener((client, newState) -> logger.info("client stat:" + newState.name()));
        if (CollectionUtils.isNotEmpty(initPersistentPaths)) {
            for (String path : initPersistentPaths) {
                createPersistentPath(path);
            }
        }
    }

    /**
     * 创建持久节点路径
     *
     * @param path
     */
    public void createPersistentPath(String path) {
        createPath(path, CreateMode.PERSISTENT);
    }

    /**
     * 创建临时节点路径
     *
     * @param path
     */
    public void createEphemeralPath(String path) {
        this.createPath(path, CreateMode.EPHEMERAL);
    }

    private void createPath(String path, CreateMode createMode) {
        if (!StringUtils.startsWith(path, SPLIT)) {
            throw new IllegalArgumentException("path must start /");
        }
        try {
            if (curatorClient.checkExists().forPath(path) != null) {
                return;
            }
            curatorClient.create().creatingParentsIfNeeded().withMode(createMode).withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                    .forPath(path);
            logger.info("create zk path {} with {} mode success", path, createMode.isEphemeral());
        } catch (Exception e) {
            logger.error("create zk path error path =" + path, e);
            throw new RuntimeException("create zk path error path =" + path, e);
        }
    }

    public void createEphemeralPathAndSetValue(String path, String value) {
        createPathAndSetValue(path, value, CreateMode.EPHEMERAL);
    }

    public void createPersistentPathAndSetValue(String path, String value) {
        createPathAndSetValue(path, value, CreateMode.PERSISTENT);
    }

    private void createPathAndSetValue(String path, String value, CreateMode createMode) {
        if (!StringUtils.startsWith(path, SPLIT)) {
            throw new IllegalArgumentException("path can not be null or empty and path must start /");
        }
        createPath(path, createMode);
        try {
            curatorClient.setData().forPath(path, value.getBytes());
            logger.info("create zk node {} in path {} success", value, path);
        } catch (Exception e) {
            logger.error("create error path=" + path + ",value=" + value, e);
            throw new RuntimeException("create error path=" + path + ",value=" + value, e);
        }
    }

    public List<String> getChildNodes(String path) {
        if (StringUtils.isBlank(path)) {
            throw new IllegalArgumentException("path can not be null or empty");
        }
        try {
            return curatorClient.getChildren().forPath(path);
        } catch (Exception e) {
            logger.error("get zookeeper getChildNodes error path=" + path, e);
            throw new RuntimeException("get zookeeper getChildNodes error path=" + path, e);
        }
    }

    public String getPathValue(String path) {
        try {

            byte[] bytes = curatorClient.getData().forPath(path);
            return bytes != null ? new String(bytes) : null;
        } catch (Exception e) {
            logger.error("get zookeeper path error path=" + path, e);
            throw new RuntimeException("get zookeeper path error path=" + path, e);
        }
    }

    public void setWatcher(String nodePath, Watcher watcher) {
        try {
            logger.info("set {} path watch", nodePath);
            curatorClient.getData().usingWatcher(watcher).forPath(nodePath);
        } catch (Exception e) {
            logger.error("set node path watcher error, node path = " + nodePath, e);
            throw new RuntimeException("set node path watcher error, node path = " + nodePath, e);
        }
    }

    public void addPathChildrenChangedEvent(String nodePath, PathChildrenCacheListener pathChildrenCacheListener) {
        final PathChildrenCache childrenCache = new PathChildrenCache(curatorClient, nodePath, true);
        try {
            childrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
            childrenCache.getListenable().addListener(pathChildrenCacheListener);
        } catch (Exception e) {
            logger.error("addPathChildrenChangedEvent error nodePath = " + nodePath, e);
            throw new RuntimeException("addPathChildrenChangedEvent error nodePath = " + nodePath, e);
        }
    }

    public void deletePath(String nodePath) {
        try {
            logger.info("delete zookeeper node {}", nodePath);
            curatorClient.delete().deletingChildrenIfNeeded().forPath(nodePath);
            logger.info("delete zookeeper node {} success", nodePath);
        } catch (Exception e) {
            logger.error("delete zookeeper node error, node = " + nodePath, e);
            throw new RuntimeException("delete zookeeper node error, node = " + nodePath, e);
        }
    }

    public void setInitPersistentPaths(List<String> initPersistentPaths) {
        this.initPersistentPaths = initPersistentPaths;
    }

    public CuratorFramework getCuratorClient() {
        return curatorClient;
    }

    public void setCuratorClient(CuratorFramework curatorClient) {
        this.curatorClient = curatorClient;
    }

    public void close() {
        curatorClient.close();
    }

    @Override
    public void destroy() throws Exception {
        close();
    }
}
