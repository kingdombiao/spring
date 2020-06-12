package com.kingdombiao.config;

import com.kingdombiao.aop.Calculator;
import com.kingdombiao.aop.LogAspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author biao
 * @create 2019-09-12 17:01
 */
@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableAsync
public class ConfigAop {

    @Bean
    public Calculator calculator(){
        return new Calculator();
    }

    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
