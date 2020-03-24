package com.kingdombiao.config;

import com.kingdombiao.circularReference.BeanB;
import com.kingdombiao.circularReference.ConfigurationA;
import com.kingdombiao.circularReference.ServiceA;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Authror biao
 * @Description: 循环依赖配置类
 * @Date: 2020-03-24 下午 2:57
 */
@Import({ServiceA.class, ConfigurationA.class, BeanB.class})
@Configuration
public class configCirc {
}
