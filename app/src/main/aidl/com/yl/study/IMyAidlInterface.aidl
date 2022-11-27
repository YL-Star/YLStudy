// IMyAidlInterface.aidl
package com.yl.study;
// Declare any non-default types here with import statements
// ################必须手动导包#########################
import com.yl.study.aidl.bean.Student;
interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    void addStudent(in Student student);

    List<Student> getStudentList();
}