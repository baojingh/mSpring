package com.bd.mspring.beans.factory.support;

import com.bd.mspring.beans.factory.config.BeanDefinition;

/**
 * @Author: baojing.he
 * @Date: 2021-03-20 23:10
 * @Description: 注册BeanDefinition
 */
public interface BeanDefinitionRegistry {
    public void registryBeanDefinition(String name, BeanDefinition beanDefinition);

}
