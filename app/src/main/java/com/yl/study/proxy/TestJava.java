package com.yl.study.proxy;

import android.util.Log;

import androidx.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @date: $ $
 * @author: yanglei
 * @description
 */
public class TestJava {
    public void test() {
        // 1.静态代理
        AnimalProxy proxy = new AnimalProxy(new Cat());
        proxy.eat();
        AnimalProxy proxy1 = new AnimalProxy(new Dog());
        proxy1.eat();


        // 2.动态代理 不需要Proxy类  反射。
        Animal animal = (Animal) Proxy.newProxyInstance(Cat.class.getClassLoader(), new Class[]{Animal.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Log.d("tag-", "========donging 前========");
                Object obj = method.invoke(new Cat(), args);
                Log.d("tag-", "========donging 后========");
                return obj;// 方法如果有值返回，没有值就返回空。
            }
        });
        animal.doing();


        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        // 生成一个代理对象。
        Animal animal2 = (Animal) Proxy.newProxyInstance(
//                TestJava.class.getClassLoader(),
                Dog.class.getClassLoader(),
                new Class[]{Animal.class},
                new MyInHandler());
//        animal2.color();
        animal2.toString();// 也会执行到invoke(); 区别

    }

    private static class MyInHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Log.d("tag-", "========color 前========");
            Object obj = method.invoke(new Dog(), args);// 在哪个对象上执行方法。
            Log.d("tag-", "========color 后========");
            return obj;// 方法如果有值返回，没有值就返回空。
        }
    }
}
