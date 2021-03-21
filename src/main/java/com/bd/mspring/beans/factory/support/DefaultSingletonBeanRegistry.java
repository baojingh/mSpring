package com.bd.mspring.beans.factory.support;

import com.bd.mspring.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: baojing.he
 * @Date: 2021-03-21 15:43
 * @Description: 增加/获取单利bean的方法
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<String, Object>();

    public Object getSingleton(String name) {
        return singletonObjects.get(name);
    }

    public void addSingleton(String name, Object obj) {
        singletonObjects.put(name, obj);
    }


}
