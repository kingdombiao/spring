package com.kingdombiao.config;


import com.kingdombiao.dao.DemoDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan({"com.kingdombiao.controller","com.kingdombiao.service","com.kingdombiao.dao"})
public class ConfigAutoInjectPriority {

    @Primary
    @Bean("demoDao2")
    public DemoDao demoDao(){
        DemoDao demoDao = new DemoDao();
        demoDao.setFlag(2);
        return demoDao;
    }
}
