package com.bd.mspring.tinyioc;

/**
 * @Author: baojing.he
 * @Date: 2021-04-03 12:45
 * @Description:
 */
public class EatCoockieService {
    private String name;

    public String eat() {
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
