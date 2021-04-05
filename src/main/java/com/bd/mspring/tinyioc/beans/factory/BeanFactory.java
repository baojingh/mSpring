package com.bd.mspring.tinyioc.beans.factory;

import com.bd.mspring.tinyioc.beans.BeanDefinition;

/**
 * @Author: baojing.he
 * @Date: 2021-03-27 20:40
 * @Description:
 */
public interface BeanFactory {

    /**
     * 根据bean名称，获取bean对象，此处对象需要强制类型转换成目标对象
     * @param beanName
     * @return
     */
    public Object getBean(String beanName);

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
