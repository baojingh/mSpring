package com.bd.mspring.tinyioc.dependencyTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: baojing.he
 * @Date: 2021-04-09 20:42
 * @Description:
 */

@Component
public class TeacherServiceImpl {

    @Autowired
    private StudentServiceImpl studentService;

//    public TeacherServiceImpl(StudentServiceImpl studentService) {
//        this.studentService = studentService;
//    }

    public void printTeacherInfo() {
        System.out.println("this is teacher service");
    }

}
