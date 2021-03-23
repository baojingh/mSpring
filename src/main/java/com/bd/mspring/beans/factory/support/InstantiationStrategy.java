package com.bd.mspring.beans.factory.support;

import com.bd.mspring.beans.factory.config.BeanDefinition;

/**
 * @Author: baojing.he
 * @Date: 2021-03-23 22:02
 * @Description:
 */
public interface InstantiationStrategy {
    public Object instantiate(BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException;
}
