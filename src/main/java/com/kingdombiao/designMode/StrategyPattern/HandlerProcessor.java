package com.kingdombiao.designMode.StrategyPattern;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author shangbiao.wang
 * @Description: TODO
 * @Date 2020-07-03 10:08
 */
@Component
public class HandlerProcessor implements BeanFactoryPostProcessor {

    private static final String HANDLER_PACKAGE="com.kingdombiao.designmode.strategypattern";

    /**
     * Modify the application context's internal bean factory after its standard
     * initialization. All bean definitions will have been loaded, but no beans
     * will have been instantiated yet. This allows for overriding or adding
     * properties even to eager-initializing beans.
     *
     * @param beanFactory the bean factory used by the application context
     * @throws BeansException in case of errors
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, Class> handleMap = Maps.newHashMapWithExpectedSize(3);
        ClassScanner.scan(HANDLER_PACKAGE,HandleType.class).forEach(clazz->{
            HandleType handleType = (HandleType) clazz.getAnnotation(HandleType.class);
            handleMap.put(handleType.value(),clazz);
        });
        HandlerContext handlerContext = new HandlerContext(handleMap);
        beanFactory.registerSingleton(HandlerContext.class.getName(),handlerContext);
    }
}
