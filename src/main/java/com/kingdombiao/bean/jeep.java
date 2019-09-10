package com.kingdombiao.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author biao
 * @create 2019-09-09 10:09
 */
//@Component
public class jeep {
    public jeep() {
        System.out.println("jeep constructor..................");
    }

    //创建对象并赋值之后调用
    @PostConstruct
    public void init(){
        System.out.println("jeep @PostConstruct..................");
    }

    //容器移除对象之前调用
    @PreDestroy
    public void destroy(){
        System.out.println("jeep @destroy..................");
    }


}
