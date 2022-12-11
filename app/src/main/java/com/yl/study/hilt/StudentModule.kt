//package com.yl.study.hilt
//
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ApplicationComponent
//import javax.inject.Singleton
//import dagger.Provides
//import com.yl.study.hilt.StudentObj
//import dagger.Module
//
///**
// * @date: $ $
// * @author: yanglei
// * @description
// */
//@InstallIn(ApplicationComponent::class)
//@Module
//object StudentModule {
//
//    @Singleton
//    @Provides
//    fun getStudentObj(): StudentObj {
//        return StudentObj()
//    }
//}