package com.spiderman.design.structure;

/**
 * 装饰器设计模式
 * 装饰器模式作用是针对目标方法进行增强，提供新的功能或者额外的功能
 * 装饰器模式涉及的是单方，和代理模式相同，而且目标必须是抽象的
 * 装饰器中持有的目标实例是从构造器传入的，而代理中持有的目标实例是自己创建的。
 */
public class TestDecorator {
    public static void main(String[] args) {
        House house=new HouseA();
        Decorator decorator=new Decorator(house);
        decorator.output();
    }
}

/**
 * 目标接口：房子
 */
interface House {
    void output();
}

/**
 * 房子实现类
 */
class HouseA implements House {
    @Override
    public void output() {
        System.out.println("这是A的房子");
    }
}
/**
 * 房子实现类
 */
class HouseB implements House {
    @Override
    public void output() {
        System.out.println("这是B的房子");
    }
}
class Decorator implements House {
    private House house;
    public Decorator(House house){
        this.house = house;
    }
    @Override
    public void output() {
        System.out.println("这是针对房子的前段装饰增强");
        house.output();
        System.out.println("这是针对房子的后段装饰增强");
    }
}