package com.yl.study.annotation_check_grammar;

import androidx.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.yl.study.annotation_check_grammar.Test2.ALVIN;
import static com.yl.study.annotation_check_grammar.Test2.LANCE;

@IntDef(value = {LANCE, ALVIN}) //限定为LANCE，ALVIN
@Target(ElementType.PARAMETER) //作用于参数的注解
@Retention(RetentionPolicy.SOURCE) //源码级别注解
public @interface Teacher {
}