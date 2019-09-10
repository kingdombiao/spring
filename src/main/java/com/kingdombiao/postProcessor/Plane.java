package com.kingdombiao.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sound.midi.Soundbank;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author biao
 * @create 2019-09-09 15:03
 */
@Component
public class Plane implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public Plane() {
        System.out.println("plane constructor............");
    }


    @PostConstruct
    public void init(){
        System.out.println("plane @PostConstruct............");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("plane @PreDestroy............");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;

    }
}
