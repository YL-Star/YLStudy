package com.yl.study.proxy;

import android.util.Log;

/**
 * @date: $ $
 * @author: yanglei
 * @description
 */
class AnimalProxy implements Animal{
    Animal animal;
    public AnimalProxy(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void color() {
        animal.color();
    }

    @Override
    public void eat() {
        Log.d("tag-","========饭前========");
        animal.eat();
        Log.d("tag-","========饭后========");
    }

    @Override
    public void doing() {
        animal.doing();
    }
}
