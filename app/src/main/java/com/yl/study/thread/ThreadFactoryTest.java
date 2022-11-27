package com.yl.study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//// 线程按顺序执行
public class ThreadFactoryTest {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newSingleThreadExecutor();
        ex.execute(() -> System.out.println("A"));
        ex.execute(() -> System.out.println("B"));
        ex.execute(() -> System.out.println("C"));
        ex.shutdown();
    }
    
}
