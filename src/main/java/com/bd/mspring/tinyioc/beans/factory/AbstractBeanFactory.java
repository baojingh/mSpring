package com.bd.mspring.tinyioc.beans.factory;

import com.bd.mspring.tinyioc.beans.BeanDefinition;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: baojing.he
 * @Date: 2021-03-27 21:39
 * @Description:
 */
public abstract class AbstractBeanFactory implements BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private List<String> beanDefinitionNames = new LinkedList<String>();

    public Object getBean(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            System.out.println("the beanDefinition not exists");
            return null;
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            try {
                bean = doCreateBean(beanDefinition);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bean;
    }

    /**
     * 注册beanDefinition：
     * 1. <name, beanDefinition>关系
     * 2. bean name列表
     *
     * @param name
     * @param beanDefinition
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);

    }

    /**
     * 预先实例化bean
     */
    public void preInstantiateSingleton() {
        Iterator<String> iterator = beanDefinitionNames.iterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            getBean(name);
        }


    }

    /**
     * 基于beanDefinition创建bean对象
     *
     * @param beanDefinition
     * @return
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;

}
