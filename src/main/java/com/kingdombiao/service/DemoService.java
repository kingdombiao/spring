package com.kingdombiao.service;

import com.kingdombiao.dao.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

@Service
public class DemoService {

    //@Qualifier("demoDao")  //是根据bean id指定获取testDao, 不受@Primary影响
    //@Autowired
    //@Resource(name = "demoDao2") // 1、不能支持@Primary功能      2、不能支持@Autowired(required = false)的功能
    @Inject   //@Inject不支持required=false,  但支持primary
    private DemoDao demoDao;

    public void printDemoDao(){
        System.out.println(demoDao);
    }
}
