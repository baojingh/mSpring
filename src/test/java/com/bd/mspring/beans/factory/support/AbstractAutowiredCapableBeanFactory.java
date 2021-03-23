package com.bd.mspring.beans.factory.support;

import com.bd.mspring.beans.factory.config.BeanDefinition;

/**
 * @Author: baojing.he
 * @Date: 2021-03-21 22:05
 * @Description:
 */
public abstract class AbstractAutowiredCapableBeanFactory extends AbstractBeanFactory {


    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object o = doCreateBean(beanName, beanDefinition);
        return o;
    }

    protected Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        Class beanClass = beanDefinition.getBeanClass();
        Object o = null;
        try {
            o = beanClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        addSingleton(beanName, o);
        return o;
    }


}
