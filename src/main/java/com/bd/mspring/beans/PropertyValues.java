package com.bd.mspring.beans;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: baojing.he
 * @Date: 2021-03-23 22:17
 * @Description:
 */
public class PropertyValues {
    private final List<PropertyValue> list = new LinkedList<PropertyValue>();
    private final Map<String, PropertyValue> map = new HashMap<String, PropertyValue>();


    public void addPropertyValue(PropertyValue pv) {
        list.add(pv);
        map.put(pv.getName(), pv);
    }

    public PropertyValue[] getPropertyValues() {
        return (PropertyValue[]) list.toArray();
    }

    public PropertyValue getPropertyValue(String name) {
        PropertyValue propertyValue = map.get(name);
        return propertyValue;
    }
}
