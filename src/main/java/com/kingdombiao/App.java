package com.kingdombiao;

import com.kingdombiao.aop.Calculator;
import com.kingdombiao.bean.*;
import com.kingdombiao.circularReference.BeanB;
import com.kingdombiao.circularReference.ClzA;
import com.kingdombiao.config.*;
import com.kingdombiao.dao.DemoDao;
import com.kingdombiao.designMode.StrategyPattern.OrderDto;
import com.kingdombiao.factoryBean.BiaoFactoryBean;
import com.kingdombiao.service.DemoService;
import com.kingdombiao.service.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
       /* ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Object person = applicationContext.getBean("person");
        System.out.println(person);*/

        ApplicationContext app = new AnnotationConfigApplicationContext(Config.class);

        Object person1 = app.getBean("person");
        System.out.println(person1);
    }

    @Test
    public void testConfigPerson() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        // Object person = applicationContext.getBean("person");
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }
    }

    @Test
    public void testComponentScan() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void testScope() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        Object person1 = applicationContext.getBean("person");
        Object person2 = applicationContext.getBean("person");
        System.out.println(person1 == person2);
    }

    @Test
    public void testLazy() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        System.out.println("******IOC容器初始化完成*******");

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        Object person1 = applicationContext.getBean("person");
        Object person2 = applicationContext.getBean("person");
        System.out.println(person1 == person2);
    }

    @Test
    public void testConditon() {
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
    public void testImport() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        System.out.println("******IOC容器初始化完成*******");

        final Map<String, Dog> beansOfType = applicationContext.getBeansOfType(Dog.class);
        System.out.println(beansOfType);
    }

    @Test
    public void testImportSelector() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        System.out.println("******IOC容器初始化完成*******");

        final Map<String, Pig> beansOfType = applicationContext.getBeansOfType(Pig.class);
        System.out.println(beansOfType);
    }


    @Test
    public void testImportBeanDefinitionRegistrar() {
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
        System.out.println("&biaoFactoryBean=" + biaoFactoryBean);
    }

    @Test
    public void testBeanLifeCycle() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        System.out.println("******IOC容器初始化完成*******");

        //applicationContext.getBean(Bike.class);

        //applicationContext.getBean(Train.class);

        //((AnnotationConfigApplicationContext) applicationContext).close();
    }

    @Test
    public void testConfigProperties() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);


        Bird bean = applicationContext.getBean(Bird.class);
        System.out.println(bean);

        //properties 会加载到环境变量中，可以直接从环境变量中去bird.color的值
        Environment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("bird.color");
        System.out.println("environment--->" + property);

        ((AnnotationConfigApplicationContext) applicationContext).close();
    }


    @Test
    public void testConfigAutoInjectPriority() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigAutoInjectPriority.class);


        DemoService demoService = applicationContext.getBean(DemoService.class);
        demoService.printDemoDao();

        DemoDao demoDao = (DemoDao) applicationContext.getBean(DemoDao.class);

        System.out.println(demoDao);

        ((AnnotationConfigApplicationContext) applicationContext).close();
    }


    @Test
    public void testConfigAop() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigAop.class);


        Calculator calculator = applicationContext.getBean(Calculator.class);

        System.out.println(calculator.div(1, 1));

        ((AnnotationConfigApplicationContext) applicationContext).close();
    }


    @Test
    public void testConfigTransaction() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigTransaction.class);


        OrderService orderService = applicationContext.getBean(OrderService.class);

        System.out.println(orderService.select(2));


        ((AnnotationConfigApplicationContext) applicationContext).close();

    }

    @Test
    public void testCircularReference() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        ClzA clzA = (ClzA) applicationContext.getBean("clzA");
        System.out.println(clzA.getClzB());

    }

    @Test
    public void testConfigCirc() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(configCirc.class);
        BeanB bean = (BeanB) applicationContext.getBean("beanB");
        System.out.println(bean);
    }

    @Test
    public void testConfigDesignMode(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigDesignMode.class);
        com.kingdombiao.designMode.StrategyPattern.OrderService orderService = applicationContext.getBean(com.kingdombiao.designMode.StrategyPattern.OrderService.class);
        String result = orderService.handle(OrderDto.builder().type("1").build());
        System.out.println(result);
    }
}
