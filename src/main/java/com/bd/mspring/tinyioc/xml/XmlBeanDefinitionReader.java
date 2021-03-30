package com.bd.mspring.tinyioc.xml;

import com.bd.mspring.tinyioc.AbstractBeanDefinitionReader;
import com.sun.xml.internal.ws.api.ResourceLoader;

/**
 * @Author: baojing.he
 * @Date: 2021-03-30 22:58
 * @Description:
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    protected XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {

    }

}
