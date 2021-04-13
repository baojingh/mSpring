package com.bd.mspring.cycleDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author: baojing.he
 * @Date: 2021-04-12 21:46
 * @Description:
 */

@Component
public class InstanceA {

    @Autowired
    private InstanceB instanceB;

    public InstanceA() {
    }

    public InstanceA(InstanceB instanceB) {
        this.instanceB = instanceB;
    }

    public void say() {
        System.out.println("I am A");
    }


    public InstanceB getInstanceB() {
        return instanceB;
    }

    public void setInstanceB(InstanceB instanceB) {
        this.instanceB = instanceB;
    }
}
