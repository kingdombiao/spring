package com.kingdombiao.config;

import com.kingdombiao.bean.Bike;
import com.kingdombiao.bean.Bird;
import com.kingdombiao.bean.Dog;
import com.kingdombiao.bean.Person;
import com.kingdombiao.condition.biaoCondition;
import com.kingdombiao.customfilter.BiaoFilterType;
import com.kingdombiao.factoryBean.BiaoFactoryBean;
import com.kingdombiao.importSelector.BiaoImportBeanDefinitionRegistrar;
import com.kingdombiao.importSelector.BiaoImportSelector;
import com.kingdombiao.service.DemoService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

@Import({Dog.class,BiaoImportSelector.class,BiaoImportBeanDefinitionRegistrar.class})
@Configuration
/*@ComponentScan(value = "com.kingdombiao",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {DemoService.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {BiaoFilterType.class})
        },
        useDefaultFilters = false)*/
@ComponentScan(value = "com.kingdombiao")
@PropertySource("classpath:/bird.properties")
public class Config {

    //@Lazy
    //@Scope(value = "prototype")
    @Bean
    public Person person() {
        //System.out.println("*******给容器添加person*******");
        return new Person("kingdombiao", 19);
    }

    @Conditional({biaoCondition.class})
    @Bean
    public Person kingdombiaoPerson() {
        //System.out.println("*******给容器添加kingdombiaoPerson*******");
        return new Person("kingdombiaoPerson", 19);
    }

    @Bean
    public BiaoFactoryBean biaoFactoryBean(){
        return new BiaoFactoryBean();
    }

    //@Scope(value = "prototype") //多实例: 容器只负责初始化,但不会管理bean, 容器关闭不会调用销毁方法
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Bike bike(){
        return new Bike();
    }

    @Bean
    public Bird bird(){
        return new Bird();
    }
}
