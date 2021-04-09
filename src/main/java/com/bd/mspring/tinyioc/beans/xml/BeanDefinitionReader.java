package com.bd.mspring.tinyioc.beans.xml;

/**
 * @Author: baojing.he
 * @Date: 2021-03-30 22:51
 * @Description:
 */
public interface BeanDefinitionReader {
    public void loadBeanDefinitions(String location) throws Exception;
}
