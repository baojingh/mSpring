package com.bd.mspring.tinyioc;

/**
 * @Author: baojing.he
 * @Date: 2021-03-27 21:32
 * @Description:
 */
public class HelloWorldService {

    private String text;

    public void hello() {
        System.out.printf(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
