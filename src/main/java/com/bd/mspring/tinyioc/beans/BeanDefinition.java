package com.bd.mspring.tinyioc.beans;

/**
 * @Author: baojing.he
 * @Date: 2021-03-27 20:40
 * @Description: 保存bean的定义，bean名称，bean类型，bean属性
 */
public class BeanDefinition {
    /**
     * bean对象，使用时需要强转成具体类型
     */
    private Object bean;

    /**
     * bean类型名称，例如"com.bd.mspring.tinyioc.EatCoockieService"
     */
    private String beanClassName;

    /**
     * class对象，存放用户自定义类的元数据信息
     */
    private Class beanClass;

    /**
     * bean对应的属性信息。包括其引用的其他bean
     */
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

    /**
     * 设置beanClassName，就自动基于此name反射出class对象
     * @param beanClassName
     */
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
