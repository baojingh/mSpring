package com.bd.mspring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: baojing.he
 * @Date: 2021-03-20 22:12
 * @Description:
 */
public class BeanFactory {
    private Map<String, Object> beanMap = new HashMap<String, Object>();

    public void registerBean(String name, Object bean) {
        beanMap.put(name, bean);
    }

    public Object getBean(String name) {
        Object o = beanMap.get(name);
        return o;
    }
}
