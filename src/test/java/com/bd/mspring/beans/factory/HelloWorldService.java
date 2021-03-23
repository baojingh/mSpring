package com.bd.mspring.beans.factory;

/**
 * @Author: baojing.he
 * @Date: 2021-03-23 08:53
 * @Description:
 */
public class HelloWorldService {
    private String name;

    public String sayHello() {
        System.out.println("hello world");
        return "world";
    }
}
