package com.bd.mspring.tinyioc;

import com.bd.mspring.tinyioc.beans.BeanDefinition;
import com.bd.mspring.tinyioc.beans.PropertyValue;
import com.bd.mspring.tinyioc.beans.PropertyValues;
import com.bd.mspring.tinyioc.beans.factory.AbstractBeanFactory;
import com.bd.mspring.tinyioc.beans.factory.AutowiredCapableBeanFactory;
import com.bd.mspring.tinyioc.beans.factory.BeanFactory;
import com.bd.mspring.tinyioc.beans.io.ResourceLoader;
import com.bd.mspring.tinyioc.beans.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

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

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text", "Hello World"));
        beanDefinition.setPropertyValues(propertyValues);

        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.hello();
    }

    @Test
    public void testLazy() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

        // 2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowiredCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.hello();
    }

    @Test
    public void testPreInstiate() {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        try {
            xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        AutowiredCapableBeanFactory beanFactory = new AutowiredCapableBeanFactory();
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        for (Map.Entry<String, BeanDefinition> entry : registry.entrySet()) {
            beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
        }

        beanFactory.preInstantiateSingleton();

        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.hello();
    }


}
