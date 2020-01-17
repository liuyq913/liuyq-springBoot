package com.liuyq.boot.zk;

import java.util.List;

/**
 * @Auther: liuyuqing
 * @Date: 2020/1/17 17:14
 * @Description:
 */
public class ZkTest {
   public static void main(String[] ahrs) throws Exception {
       CuratorZookeeperClient curatorZookeeperClient =  new CuratorZookeeperClient();
      List<String> childrens =  curatorZookeeperClient.getChildren("/dubbo");
}
}
