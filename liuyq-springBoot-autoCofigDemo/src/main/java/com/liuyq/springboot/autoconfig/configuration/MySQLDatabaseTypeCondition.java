package com.liuyq.springboot.autoconfig.configuration;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by liuyq on 2019/6/27.
 */
public class MySQLDatabaseTypeCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String enabledDBType = System.getProperty("dbType"); // 获得系统参数 dbType
        // 如果该值等于MySql，则条件成立
        return (enabledDBType != null && enabledDBType.equalsIgnoreCase("MySql"));
    }
}
