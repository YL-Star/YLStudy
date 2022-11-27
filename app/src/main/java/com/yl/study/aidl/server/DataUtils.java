package com.yl.study.aidl.server;

import com.yl.study.aidl.bean.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @date: $ $
 * @author: yanglei
 * @description
 */
public class DataUtils {
    private final static List<Student> studentList = new ArrayList<>();

    public static List<Student> getStudentList() {
        return studentList;
    }
}
