package com.kingdombiao.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class biaoCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        //获取到ioc容器使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        //获取到类加载器
        ClassLoader classLoader = context.getClassLoader();

        //获取当前环境信息
        Environment environment = context.getEnvironment();

        //获取bean 定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String environmentProperty = environment.getProperty("os.name");

        if ("Windows".contains(environmentProperty)) {
            return true;
        }
        return false;
    }
}
