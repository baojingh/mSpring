package com.bd.mspring.cycleDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: baojing.he
 * @Date: 2021-04-12 21:46
 * @Description:
 */

@Component
public class InstanceB {

    @Autowired
    private InstanceA instanceA;

    public InstanceB(InstanceA instanceA) {
        this.instanceA = instanceA;
    }

    public void say() {
        System.out.println("I am B");
    }

    public InstanceA getInstanceA() {
        return instanceA;
    }

    public void setInstanceA(InstanceA instanceA) {
        this.instanceA = instanceA;
    }
}
