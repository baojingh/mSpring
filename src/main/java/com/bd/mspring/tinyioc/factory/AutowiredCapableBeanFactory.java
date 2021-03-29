package com.bd.mspring.tinyioc.factory;

import com.bd.mspring.tinyioc.BeanDefinition;
import com.bd.mspring.tinyioc.PropertyValue;
import com.bd.mspring.tinyioc.PropertyValues;

import java.lang.reflect.Field;

/**
 * @Author: baojing.he
 * @Date: 2021-03-27 21:44
 * @Description:
 */
public class AutowiredCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        Class beanClass = beanDefinition.getBeanClass();
        Object o = beanClass.newInstance();
        return o;
    }

    protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
        for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValueList()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean, propertyValue.getValue());
        }
    }

}
