package com.bd.mspring.tinyioc.factory;

import com.bd.mspring.tinyioc.BeanDefinition;

/**
 * @Author: baojing.he
 * @Date: 2021-03-27 20:40
 * @Description:
 */
public interface BeanFactory {

    public Object getBean(String beanName);

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
