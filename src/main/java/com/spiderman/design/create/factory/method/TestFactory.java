package com.spiderman.design.create.factory.method;

/**
 * 工厂模式
 * 定义：定义一个用于创建对象的接口，让子类决定实例化哪一个类。使一个类的实例化延迟到其子类
 * 适用：当一个类不知道它所必须创建的对象的类的时候
 */

public class TestFactory {
    public static void main(String[] args) {
        //普通模式
        IFactory factory = new FactoryA();
        IProduct product = factory.getProduct();
        product.produce();
        factory = new FactoryB();
        product = factory.getProduct();
        product.produce();
        // 使用工厂方法
        Factory factory1 = new Factory();
        IProduct product1 = factory1.getProduct(1);
        product1.produce();
        IProduct product2 = factory1.getProduct(2);
        product2.produce();
    }
}

interface IProduct {
    void produce();
}

class ProductA implements IProduct {
    @Override
    public void produce() {
        System.out.println("生产1");
    }
}

class ProductB implements IProduct {
    @Override
    public void produce() {
        System.out.println("生产2");
    }
}

interface IFactory {
    IProduct getProduct();
}

class FactoryA implements IFactory {
    @Override
    public IProduct getProduct() {
        return new ProductA();
    }
}

class FactoryB implements IFactory {
    @Override
    public IProduct getProduct() {
        return new ProductB();
    }
}

/**
 * 工厂方法
 */
class Factory {
    public IProduct getProductA() {
        return new ProductA();
    }

    public IProduct getProductB() {
        return new ProductB();
    }

    public IProduct getProduct(int type) {
        if (type == 1) {
            return getProductA();
        } else {
            return getProductB();
        }
    }
}
