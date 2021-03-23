package com.bd.mspring.beans.factory.support;

import com.bd.mspring.beans.factory.BeanFactory;
import com.bd.mspring.beans.factory.config.BeanDefinition;

/**
 * @Author: baojing.he
 * @Date: 2021-03-21 21:54
 * @Description:
 */
public abstract class AbstractBeanFactory
        extends DefaultSingletonBeanRegistry implements BeanFactory {

    public Object getBean(String name) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);

    protected abstract BeanDefinition getBeanDefinition(String beanName);

}
