package com.bd.mspring.tinyioc;

import com.bd.mspring.tinyioc.factory.AutowiredCapableBeanFactory;
import com.bd.mspring.tinyioc.factory.BeanFactory;
import org.junit.Test;

/**
 * @Author: baojing.he
 * @Date: 2021-03-27 21:31
 * @Description:
 */
public class BeanFactoryTest {

    @Test
    public void test() {
        BeanFactory beanFactory = new AutowiredCapableBeanFactory();
        /**
         * BeanDefinition中的bean就是指的一个实例化的对象
         */
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.bd.mspring.tinyioc.HelloWorldService");
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        String hello = helloWorldService.hello();
        System.out.println(hello);
    }


}
