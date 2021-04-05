package com.bd.mspring.tinyioc.context;

import com.bd.mspring.tinyioc.HelloWorldService;
import org.junit.Test;

/**
 * @Author: baojing.he
 * @Date: 2021-04-05 15:51
 * @Description:
 */
public class ApplicationContextTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tinyioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) context.getBean("helloWorldService");
        helloWorldService.hello();
    }

}
