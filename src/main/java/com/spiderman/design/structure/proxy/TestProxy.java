package com.spiderman.design.structure.proxy;

/**
 * 代理模式
 * 代理类与委托类实现同一接口
 * 在委托类中实现功能，在代理类的方法中中引用委托类的同名方法
 * 外部类调用委托类某个方法时，直接以接口指向代理类的实例，这正是代理的意义所在：屏蔽。
 */
public class TestProxy {
    public static void main(String[] args) {
        ProxyPeople proxyPeople = new ProxyPeople();
        proxyPeople.sleep();
    }
}

interface People {

    void sleep();
}

/**
 * 委托类
 */
class NormalPeople implements People{
    public void eat() {
        System.out.println("普通人吃饭");
    }

    public void sport() {
        System.out.println("普通人运动");

    }
    @Override
    public void sleep() {
        System.out.println("普通人睡觉");
    }
}

/**
 * 代理类
 */
class ProxyPeople implements People{
    NormalPeople normalPeople=new NormalPeople();
    @Override
    public void sleep() {
        System.out.println("刷牙");
        normalPeople.sleep();
        System.out.println("打呼噜");
    }
}