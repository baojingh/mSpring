package com.bd.mspring.beans;

/**
 * @Author: baojing.he
 * @Date: 2021-03-23 22:17
 * @Description:
 */
public class PropertyValue {
    private String name;
    private String value;

    public PropertyValue() {
    }

    public PropertyValue(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
