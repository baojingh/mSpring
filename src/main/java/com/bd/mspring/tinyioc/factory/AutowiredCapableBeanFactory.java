package com.bd.mspring.tinyioc.factory;

import com.bd.mspring.tinyioc.BeanDefinition;

/**
 * @Author: baojing.he
 * @Date: 2021-03-27 21:44
 * @Description:
 */
public class AutowiredCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            Object bean = beanDefinition.getClass().newInstance();
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        return null;
    }
}
