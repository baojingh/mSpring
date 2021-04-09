package com.bd.mspring.tinyioc.beans.factory;

import com.bd.mspring.tinyioc.beans.BeanDefinition;
import com.bd.mspring.tinyioc.BeanReference;
import com.bd.mspring.tinyioc.beans.PropertyValue;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @Author: baojing.he
 * @Date: 2021-03-27 21:44
 * @Description:
 */
public class AutowiredCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    /**
     * 创建bean对象
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        Class beanClass = beanDefinition.getBeanClass();
        Object o = beanClass.newInstance();
        return o;
    }

    protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
        List<PropertyValue> propertyValueList = mbd.getPropertyValues().getPropertyValueList();
        for (PropertyValue propertyValue : propertyValueList) {
            Class<?> aClass = bean.getClass();
            Field declaredField = aClass.getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            declaredField.set(bean, value);
        }
    }

}
