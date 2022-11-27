package com.yl.study.threadlocal;

import android.util.Log;

/**
 * @date: $ $
 * @author: yanglei
 * @description
 */
public class ThreadLocal_Test {
    public static void main(String[] args) {
        java.lang.ThreadLocal<Integer> num = new java.lang.ThreadLocal<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    num.set(i);
                }
                Log.d("TAG-", "===1==" + num);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    num.set(i);
                }
                Log.d("TAG-", "==2===" + num);
            }
        }).start();

    }
}
