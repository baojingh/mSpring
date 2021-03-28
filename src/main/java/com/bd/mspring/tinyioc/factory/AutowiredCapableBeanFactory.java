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
            /**
             * 获取当前beanDefinition的bean类型，不是getClass
             */
            Object bean = beanDefinition.getBeanClass().newInstance();
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
