package com.bd.mspring.tinyioc.context;

import com.bd.mspring.tinyioc.beans.BeanDefinition;
import com.bd.mspring.tinyioc.beans.factory.AbstractBeanFactory;
import com.bd.mspring.tinyioc.beans.factory.AutowiredCapableBeanFactory;
import com.bd.mspring.tinyioc.beans.io.ResourceLoader;
import com.bd.mspring.tinyioc.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @Author: baojing.he
 * @Date: 2021-04-05 15:43
 * @Description:
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) {
        this(new AutowiredCapableBeanFactory(), configLocation);
        this.configLocation = configLocation;
    }

    public ClassPathXmlApplicationContext(AbstractBeanFactory beanFactory, String configLocation) {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        try {
            xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        for (Map.Entry<String, BeanDefinition> entry : registry.entrySet()) {
            beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {

    }


}
