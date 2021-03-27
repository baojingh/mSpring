package com.bd.mspring.tinyioc;

/**
 * @Author: baojing.he
 * @Date: 2021-03-27 20:40
 * @Description: 保存bean的定义，bean名称，bean类型，bean属性
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition() {
    }

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return this.bean;
    }


}
