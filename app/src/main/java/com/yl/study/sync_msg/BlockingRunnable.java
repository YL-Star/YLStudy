package com.yl.study.sync_msg;

import java.util.concurrent.Callable;

/**
 * @date: $ $
 * @author: yanglei
 * @description
 */
public class BlockingRunnable<T> implements Runnable {
    private final Callable<T> callable;
    private T mResult;

    public T getResult() {
        return mResult;
    }

    public BlockingRunnable(Callable<T> callable) {
        this.callable = callable;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            mResult = callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }

        notifyAll();
    }
}
