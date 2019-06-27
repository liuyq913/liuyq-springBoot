package com.liuyq.springboot.autoconfig.configuration;

import com.liuyq.springboot.autoconfig.annotation.DatabaseType;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * Created by liuyq on 2019/6/27.
 */
public class DatabaseTypeCondition implements Condition{

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Map<String, Object> attributes = annotatedTypeMetadata
                .getAnnotationAttributes(DatabaseType.class.getName());
        String type = (String) attributes.get("value");
        // 默认值为MySql
        String enabledDBType = System.getProperty("dbType", "MySql");
        return (enabledDBType != null && type != null && enabledDBType.equalsIgnoreCase(type));
    }
}
