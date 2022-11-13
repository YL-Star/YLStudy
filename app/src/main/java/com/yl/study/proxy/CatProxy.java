package com.yl.study.proxy;

/**
 * @date: $ $
 * @author: yanglei
 * @description
 */
class CatProxy implements Animal{
    Animal animal;
    public CatProxy(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void color() {
        animal.color();
    }

    @Override
    public void eat() {
        animal.eat();
    }

    @Override
    public void doing() {
        animal.doing();
    }
}
