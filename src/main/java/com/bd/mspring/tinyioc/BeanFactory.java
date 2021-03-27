package com.bd.mspring.tinyioc;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: baojing.he
 * @Date: 2021-03-27 20:40
 * @Description:
 */
public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();

    public Object getBean(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        return beanDefinition.getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }


}
