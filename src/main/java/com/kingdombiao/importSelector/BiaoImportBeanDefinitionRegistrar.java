package com.kingdombiao.importSelector;

import com.kingdombiao.bean.Cat;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class BiaoImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        boolean beanDefinition1 = registry.containsBeanDefinition("com.kingdombiao.bean.Dog");
        boolean beanDefinition2 = registry.containsBeanDefinition("com.kingdombiao.bean.Pig");

        if(beanDefinition1&& beanDefinition1){
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Cat.class);
            registry.registerBeanDefinition("cat",rootBeanDefinition);
        }
    }
}
