package com.yl.annotation.arouter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @date: $ $
 * @author: yanglei
 * @description
 */
@Target(ElementType.TYPE)//该注解作用在类上
@Retention(RetentionPolicy.CLASS)//编译时预处理操作，注解会在class文件中存在
public @interface ARouter {
    String path();//详细的路由路径。如：“ui/mainActity”

    String group() default "";//路由组名
}
