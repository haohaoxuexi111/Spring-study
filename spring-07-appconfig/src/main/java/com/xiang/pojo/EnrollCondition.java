package com.xiang.pojo;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * springIOC条件注册中的条件类
 */
public class EnrollCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 获取bean注册器
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        // 判断该IOC容器中是否还有id为testNoScan的组件，若有，则条件生效
        if (registry.containsBeanDefinition("testNoScan")) {
            return true;
        }

        return false;
    }
}
