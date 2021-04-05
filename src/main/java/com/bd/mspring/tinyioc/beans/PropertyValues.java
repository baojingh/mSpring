package com.bd.mspring.tinyioc.beans;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: baojing.he
 * @Date: 2021-03-28 21:42
 * @Description:
 */
public class PropertyValues {
    private List<PropertyValue> propertyValueList = new LinkedList<PropertyValue>();

    public PropertyValues() {
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }
}
