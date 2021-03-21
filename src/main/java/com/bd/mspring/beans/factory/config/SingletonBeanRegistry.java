package com.bd.mspring.beans.factory.config;

/**
 * @Author: baojing.he
 * @Date: 2021-03-21 15:42
 * @Description: 添加/获取单利bean的方法
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String name);
}
