package com.bd.mspring.tinyioc.context;

import com.bd.mspring.tinyioc.beans.factory.AbstractBeanFactory;

/**
 * @Author: baojing.he
 * @Date: 2021-04-05 15:35
 * @Description:
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    protected AbstractBeanFactory beanFactory;

    @Override
    public Object getBean(String beanName) {
        Object bean = beanFactory.getBean(beanName);
        return bean;
    }

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() {

    }
}
