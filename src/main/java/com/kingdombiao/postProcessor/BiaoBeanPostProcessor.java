package com.kingdombiao.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * 后置处理器，bean初始化前后进行处理工作
 *
 * @author biao
 * @create 2019-09-09 10:17
 */
//@Component
public class BiaoBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization----->"+beanName+"---->bean:"+bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization----->"+beanName+"---->bean:"+bean);
        return bean;
    }
}
