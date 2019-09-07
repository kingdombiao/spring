package com.kingdombiao.config;

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
@ComponentScan(value = "com.kingdombiao",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {DemoService.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {BiaoFilterType.class})
        },
        useDefaultFilters = false
)
public class Config {

    //@Lazy
    //@Scope(value = "prototype")
    @Bean
    public Person person() {
        System.out.println("*******给容器添加person*******");
        return new Person("kingdombiao", 19);
    }

    @Conditional({biaoCondition.class})
    @Bean
    public Person kingdombiaoPerson() {
        System.out.println("*******给容器添加kingdombiaoPerson*******");
        return new Person("kingdombiaoPerson", 19);
    }

    @Bean
    public BiaoFactoryBean biaoFactoryBean(){
        return new BiaoFactoryBean();
    }
}
