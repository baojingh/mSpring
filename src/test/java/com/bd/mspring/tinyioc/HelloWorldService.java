package com.bd.mspring.tinyioc;

/**
 * @Author: baojing.he
 * @Date: 2021-03-27 21:32
 * @Description:
 */
public class HelloWorldService {

    private String text;
    private EatCoockieService eatCoockieService;


    public void setEatCoockieService(EatCoockieService eatCoockieService) {
        this.eatCoockieService = eatCoockieService;
    }

    public void hello() {
        eatCoockieService.eat("bj");
        System.out.println(text);
    }

    public void setText(String text) {
        this.text = text;
    }
}
