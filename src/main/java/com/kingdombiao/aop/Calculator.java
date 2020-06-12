package com.kingdombiao.aop;

import org.springframework.scheduling.annotation.Async;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author biao
 * @create 2019-09-12 17:09
 */
public class Calculator {

    @Async
    public int div(int i,int j){
        System.out.println("运算执行中........");
        return i/j;
    }
}
