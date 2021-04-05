package com.bd.mspring.tinyioc.beans.xml;

import com.bd.mspring.tinyioc.beans.BeanDefinition;
import com.bd.mspring.tinyioc.EatCoockieService;
import com.bd.mspring.tinyioc.HelloWorldService;
import com.bd.mspring.tinyioc.beans.factory.AutowiredCapableBeanFactory;
import com.bd.mspring.tinyioc.beans.factory.BeanFactory;
import com.bd.mspring.tinyioc.beans.io.ResourceLoader;
import org.junit.Test;

import java.util.Map;

/**
 * @Author: baojing.he
 * @Date: 2021-04-01 22:26
 * @Description:
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();

        BeanFactory beanFactory = new AutowiredCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> entry : registry.entrySet()) {
            String name = entry.getKey();
            BeanDefinition definition = entry.getValue();
            beanFactory.registerBeanDefinition(name, definition);
        }
        HelloWorldService hellowWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        hellowWorldService.hello();


        EatCoockieService eatCoockieService = (EatCoockieService) beanFactory.getBean("eatCoockieService");
        eatCoockieService.setName("bj");

        eatCoockieService.eat("bj");

    }
}
