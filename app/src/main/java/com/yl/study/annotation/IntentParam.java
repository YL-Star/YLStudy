package com.yl.study.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * @date: $ $
 * @author: yanglei
 * @description
 */
@Retention(RUNTIME)
@Target({ElementType.FIELD})
public @interface IntentParam {
    String key() default "";
}
