package com.yl.study.sync_msg;

import android.util.Log;

import java.util.HashMap;

/**
 * @date: $ $
 * @author: yanglei
 * @description
 */
public class Utils {
    private static HashMap<String,String> map = new HashMap<>();

    public static String getMap(String key) {
        return map.get(key);
    }

    public static void setMap(String key,String s) {
        map.put(key,s);
    }

    public String postAndWait(BlockingRunnable<String> blockingRunnable) {
        blockingRunnable.run();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return blockingRunnable.getResult();
    }

    public static String sendMessageSyncTask() {
        final String[] result = new String[1];
        Object obj = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {

                result[0] = "我拿到结果了," + Thread.currentThread().toString();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj) {
                    obj.notify();
                }
            }
        }).start();
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result[0];

    }
}
