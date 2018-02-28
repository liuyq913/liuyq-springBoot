package com.liuyq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by liuyq on 2017/12/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ReadingListApplication.class)//通过spring boot加载上下文
@WebAppConfiguration
public class ReadingListApplicationTest {

    @Test
    public void contxtLoads(){
        System.out.println("haha");
    }
}
