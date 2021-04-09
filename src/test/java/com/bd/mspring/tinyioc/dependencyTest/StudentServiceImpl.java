package com.bd.mspring.tinyioc.dependencyTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Author: baojing.he
 * @Date: 2021-04-09 20:42
 * @Description:
 */

@Component
public class StudentServiceImpl {

    @Autowired
    private TeacherServiceImpl teacherService;

//    public StudentServiceImpl(@Lazy(value = false) TeacherServiceImpl teacherService) {
//        this.teacherService = teacherService;
//    }

    public void printStudentInfo() {
        System.out.println("this is student service");
    }
}
