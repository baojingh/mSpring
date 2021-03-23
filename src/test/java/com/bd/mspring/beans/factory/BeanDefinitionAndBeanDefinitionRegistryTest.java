package com.bd.mspring.beans.factory;

import com.bd.mspring.beans.factory.config.BeanDefinition;
import com.bd.mspring.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @Author: baojing.he
 * @Date: 2021-03-23 08:51
 * @Description:
 */
public class BeanDefinitionAndBeanDefinitionRegistryTest {
    @Test
    public void testBeanFactory() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition helloWorldBeanDefinition = new BeanDefinition();
        helloWorldBeanDefinition.setBeanClass(HelloWorldService.class);
        beanFactory.registryBeanDefinition("helloService", helloWorldBeanDefinition);

        HelloWorldService helloService = (HelloWorldService) beanFactory.getBean("helloService");
        String hello = helloService.sayHello();
        System.out.printf(hello);
    }


}
