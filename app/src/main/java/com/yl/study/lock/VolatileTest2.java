package com.yl.study.lock;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 保证原子性，jdk1.5之后，并发包提供了很多原子类，例如AtomicInteger
 * AtomicInteger解决了同步， 最后的结果最大的肯定是10000
 */
public class VolatileTest2 extends Thread {
    private static AtomicInteger count = new AtomicInteger();


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            count.incrementAndGet();
        }
        System.out.println("tag-"+Thread.currentThread().getName() + ":" + count.get());
    }

    @Test
    public static void main(String[] args) {
        // 创建10个线程
        VolatileTest2[] list = new VolatileTest2[10];
        for (int i = 0; i < list.length; i++) {
            list[i] = new VolatileTest2();
        }
        //10个线程启动
        for (int i = 0; i < list.length; i++) {
            list[i].start();
        }
    }
}