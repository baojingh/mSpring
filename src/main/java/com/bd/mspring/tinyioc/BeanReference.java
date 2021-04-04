package com.bd.mspring.tinyioc;

/**
 * @Author: baojing.he
 * @Date: 2021-04-04 10:34
 * @Description:
 */
public class BeanReference {
    private String name;
    private Object bean;

    public BeanReference(String name, Object bean) {
        this.name = name;
        this.bean = bean;
    }

    public BeanReference(Object bean) {
        this.bean = bean;
    }

    public BeanReference() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
