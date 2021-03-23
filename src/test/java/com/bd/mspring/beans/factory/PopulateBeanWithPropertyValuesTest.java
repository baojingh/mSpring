package com.bd.mspring.beans.factory;

import com.bd.mspring.beans.PropertyValue;
import com.bd.mspring.beans.PropertyValues;
import com.bd.mspring.beans.factory.config.BeanDefinition;
import com.bd.mspring.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @Author: baojing.he
 * @Date: 2021-03-23 23:06
 * @Description:
 */
public class PopulateBeanWithPropertyValuesTest {

    @Test
    public void testPopulateBeanWithPropertyValues() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "bob"));
        propertyValues.addPropertyValue(new PropertyValue("age", "18"));
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValues);
        beanFactory.registryBeanDefinition("person", beanDefinition);
        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person.getName() + " " + person.getAge());
    }
}
