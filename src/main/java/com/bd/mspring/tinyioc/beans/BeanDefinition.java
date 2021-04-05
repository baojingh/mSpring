package com.bd.mspring.tinyioc.beans;

/**
 * @Author: baojing.he
 * @Date: 2021-03-27 20:40
 * @Description: 保存bean的定义，bean名称，bean类型，bean属性
 */
public class BeanDefinition {
    private Object bean;
    private String beanClassName;
    private Class beanClass;
    private PropertyValues propertyValues = new PropertyValues();

    public BeanDefinition() {
    }

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return this.bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            Class aClass = Class.forName(beanClassName);
            this.beanClass = aClass;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
