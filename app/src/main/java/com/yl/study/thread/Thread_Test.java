package com.yl.study.thread;

import android.util.Log;

/**
 * @date: $ $
 * @author: yanglei
 * @description
 */
public class Thread_Test {

    // 线程按顺序执行 join
    // 守护线程。

    public static void main() throws InterruptedException {
        Thread a = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("tag-","==============A");
        });
        Thread b = new Thread(() -> {
            try {
                a.join();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("tag-","==================B");
        });
        Thread c = new Thread(() -> {
            try {
                b.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("tag-","=======================C");
        });

        c.start();
        b.start();
        a.start();
        //执行顺序，a b c
    }
}
