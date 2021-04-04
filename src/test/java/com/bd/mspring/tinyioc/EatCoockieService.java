package com.bd.mspring.tinyioc;

import org.junit.Assert;

/**
 * @Author: baojing.he
 * @Date: 2021-04-03 12:45
 * @Description:
 */
public class EatCoockieService {
    private String name;
    private HelloWorldService helloWorldService;

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    public String eat(String name) {
        Assert.assertNotNull(helloWorldService);
        System.out.println("eat some coockies, " + name);
        return "eat finish";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
