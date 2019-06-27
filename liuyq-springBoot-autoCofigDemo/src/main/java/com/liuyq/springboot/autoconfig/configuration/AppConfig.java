package com.liuyq.springboot.autoconfig.configuration;

import com.liuyq.springboot.autoconfig.annotation.DatabaseType;
import com.liuyq.springboot.autoconfig.dao.JdbcUserDAO;
import com.liuyq.springboot.autoconfig.dao.MongoUserDAO;
import com.liuyq.springboot.autoconfig.interfaces.UserDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liuyq on 2019/6/27.
 */
@Configuration
@ComponentScan
public class AppConfig {
    @Bean
    //@Conditional(MySQLDatabaseTypeCondition.class)
    @DatabaseType("Mysql")
    public UserDAO jdbcUserDAO() {
        return new JdbcUserDAO();
    }

    @Bean
    @DatabaseType("mangoDB")
    //@Conditional(MongoDBDatabaseTypeCondition.class)
    public UserDAO mongoUserDAO() {
        return new MongoUserDAO();
    }
}
