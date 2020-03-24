package com.kingdombiao.circularReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * @Authror biao
 * @Description: TODO
 * @Date: 2020-03-24 下午 3:01
 */
public class ConfigurationA {
    @Autowired
    public BeanB beanB;

    @Bean
    public BeanA beanA() {
        return new BeanA();
    }
}
