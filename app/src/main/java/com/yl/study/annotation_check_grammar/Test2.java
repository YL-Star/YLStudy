package com.yl.study.annotation_check_grammar;

/**
 * 参数限制
 * @date: $ $
 * @author: yanglei
 * @description
 */
public class Test2 {
    public static final int LANCE = 1;
    public static final int ALVIN = 2;

    public static void main(String[] args) {
//        test(1);会报错。idea语法检查。
        test(LANCE);

    }

    public static void test(@Teacher int teacher) {
    }
}
