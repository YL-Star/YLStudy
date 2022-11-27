package com.yl.study.lock;

import java.util.concurrent.locks.ReentrantLock;

import javax.security.auth.callback.Callback;

/**
 * @date: $ $
 * @author: yanglei
 * @description
 */
public class ReentrantLock_Test {

    private static ReentrantLock reentrantLock;

    public static void main(String[] args) {
        reentrantLock = new ReentrantLock();
    }

    private void test(){
        reentrantLock.lock();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();

        }
    }


}
