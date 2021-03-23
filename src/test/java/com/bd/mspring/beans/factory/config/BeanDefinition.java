package com.bd.mspring.beans.factory.config;

/**
 * @Author: baojing.he
 * @Date: 2021-03-20 22:43
 * @Description: 定义bean信息的类，可以定义bean的class类型，构造参数，属性值等，每个bean对应一个
 * BeanDefinition的实例。当前可以简化成只包含class类型
 */
public class BeanDefinition {

    /**
     * 这些都是bean的属性。。。
     */
    private Class beanClass;
    private String owner;

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
