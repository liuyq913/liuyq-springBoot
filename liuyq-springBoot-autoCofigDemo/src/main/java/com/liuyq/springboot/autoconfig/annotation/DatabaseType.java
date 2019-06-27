package com.liuyq.springboot.autoconfig.annotation;

import com.liuyq.springboot.autoconfig.configuration.DatabaseTypeCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * Created by liuyq on 2019/6/27.
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(DatabaseTypeCondition.class)
public @interface DatabaseType {
    String value();
}
