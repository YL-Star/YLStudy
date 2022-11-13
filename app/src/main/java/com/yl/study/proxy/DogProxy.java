package com.yl.study.proxy;

/**
 * @date: $ $
 * @author: yanglei
 * @description
 */
class DogProxy implements Animal{
    Animal animal;
    public DogProxy(Animal animal) {
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
