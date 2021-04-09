package com.bd.mspring.tinyioc.beans.xml;


import com.bd.mspring.tinyioc.beans.BeanDefinition;
import com.bd.mspring.tinyioc.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: baojing.he
 * @Date: 2021-03-30 22:52
 * @Description:
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private Map<String, BeanDefinition> registry;
    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        this.registry = new HashMap<String, BeanDefinition>();
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
