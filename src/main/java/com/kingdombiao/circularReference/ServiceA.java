package com.kingdombiao.circularReference;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Authror biao
 * @Description: TODO
 * @Date: 2020-03-24 下午 2:58
 */
public class ServiceA {

    @Autowired
    private BeanB beanB;

    @Autowired
    private BeanA beanA;
}
