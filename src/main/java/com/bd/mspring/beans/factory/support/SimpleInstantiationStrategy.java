package com.bd.mspring.beans.factory.support;

import com.bd.mspring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Author: baojing.he
 * @Date: 2021-03-23 22:04
 * @Description:
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    public Object instantiate(BeanDefinition beanDefinition) {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            Constructor declaredConstructor = beanClass.getDeclaredConstructor();
            Object o = declaredConstructor.newInstance();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
