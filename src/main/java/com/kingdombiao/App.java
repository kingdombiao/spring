package com.kingdombiao;

import com.kingdombiao.bean.*;
import com.kingdombiao.config.Config;
import com.kingdombiao.factoryBean.BiaoFactoryBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Object person = applicationContext.getBean("person");


        System.out.println(person);
    }

    @Test
    public void testConfigPerson(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
       // Object person = applicationContext.getBean("person");
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }
    }

    @Test
    public void testComponentScan(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void testScope(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        Object person1 = applicationContext.getBean("person");
        Object person2 = applicationContext.getBean("person");
        System.out.println(person1==person2);
    }

    @Test
    public void testLazy(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        System.out.println("******IOC容器初始化完成*******");

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        Object person1 = applicationContext.getBean("person");
        Object person2 = applicationContext.getBean("person");
        System.out.println(person1==person2);
    }

    @Test
    public void testConditon(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        System.out.println("******IOC容器初始化完成*******");

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        final Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }

    @Test
    public void testImport(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        System.out.println("******IOC容器初始化完成*******");

        final Map<String, Dog> beansOfType = applicationContext.getBeansOfType(Dog.class);
        System.out.println(beansOfType);
    }

    @Test
    public void testImportSelector(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        System.out.println("******IOC容器初始化完成*******");

        final Map<String, Pig> beansOfType = applicationContext.getBeansOfType(Pig.class);
        System.out.println(beansOfType);
    }



    @Test
    public void testImportBeanDefinitionRegistrar(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        System.out.println("******IOC容器初始化完成*******");

        final Map<String, Cat> beansOfType = applicationContext.getBeansOfType(Cat.class);
        System.out.println(beansOfType);
    }

    @Test
    public void testBeanFactory() throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        System.out.println("******IOC容器初始化完成*******");

        final Map<String, Fish> beansOfType = applicationContext.getBeansOfType(Fish.class);
        System.out.println(beansOfType);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        BiaoFactoryBean biaoFactoryBean = (BiaoFactoryBean) applicationContext.getBean("&biaoFactoryBean");
        System.out.println("&biaoFactoryBean="+biaoFactoryBean);
    }

}
