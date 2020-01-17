package com.liuyq.boot.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.RetryNTimes;

import java.util.List;

/**
 * @Auther: liuyuqing
 * @Date: 2020/1/17 17:05
 * @Description:
 */
public class CuratorZookeeperClient extends AbstractZKClient {

    private final CuratorFramework client;

    public CuratorZookeeperClient() {
        try {
            CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder()
                    .connectString("122.51.31.231:2181")
                    .retryPolicy(new RetryNTimes(1, 1000))
                    .connectionTimeoutMs(5000);
            client = builder.build();
            client.getConnectionStateListenable().addListener(new ConnectionStateListener() {
                @Override
                public void stateChanged(CuratorFramework client, ConnectionState state) {
                    if (state == ConnectionState.LOST) {
                        CuratorZookeeperClient.this.stateChanged(StateListener.DISCONNECTED);
                    } else if (state == ConnectionState.CONNECTED) {
                        CuratorZookeeperClient.this.stateChanged(StateListener.CONNECTED);
                    } else if (state == ConnectionState.RECONNECTED) {
                        CuratorZookeeperClient.this.stateChanged(StateListener.RECONNECTED);
                    }
                }
            });
            client.start();
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }



    @Override
    protected void createPersistent(String path) {

    }

    @Override
    protected void createEphemeral(String path) {

    }

    @Override
    protected void createPersistent(String path, String data) {

    }

    @Override
    protected void createEphemeral(String path, String data) {

    }

    @Override
    protected boolean checkExists(String path) {
        return false;
    }

    @Override
    protected void doClose() {
        client.close();
    }

    @Override
    public void create(String path, boolean ephemeral) {

    }

    @Override
    public void delete(String path) throws Exception {
        client.delete().forPath(path);
    }

    @Override
    public List<String> getChildren(String path) throws Exception {
        return client.getChildren().forPath(path);
    }

    @Override
    public boolean isConnected() {
        return false;
    }
}
