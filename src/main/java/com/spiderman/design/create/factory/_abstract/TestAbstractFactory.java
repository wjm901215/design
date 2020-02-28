package com.spiderman.design.create.factory._abstract;

/**
 * 抽象工厂模式
 *定义：提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类
 *适用：一个系统要独立于它的产品的创建、组合和表示时
 *与工厂模式的区别：工厂模式的一个工厂接口的子类只能实例化一个产品；抽象工厂能实例多个产品
 */
public class TestAbstractFactory {
    public static void main(String[] args) {
        IFactory factory = new FactoryA();
        IProduct1 product1A = factory.getProduct1();
        IProduct2 product2A = factory.getProduct2();


        // 如果扩展产品系列B时，添加 FactoryB、ProductB即可，不需要修改原来代码
        factory = new FactoryB();
        IProduct1 product1B = factory.getProduct1();
        IProduct2 product2B = factory.getProduct2();

    }
}

// 产品1
interface IProduct1 {
}
// 扩展产品1 A系列
class Product1A implements IProduct1 {
}

// 扩展产品1 B系列
class Product1B implements IProduct1 {
}

// 产品2
interface IProduct2 {
}
// 扩展产品2 A系列
class Product2A implements IProduct2 {
}

// 扩展产品2 B系列
class Product2B implements IProduct2 {
}

// 工厂
interface IFactory {
    public IProduct1 getProduct1();

    public IProduct2 getProduct2();
};

// 工厂 A ，生产A系列产品
class FactoryA implements IFactory {
    @Override
    public IProduct1 getProduct1() {
        return new Product1A();
    }


    @Override
    public IProduct2 getProduct2() {
        return new Product2A();
    }

}

// 工厂 B ，生产B系列产品
class FactoryB implements IFactory {
    @Override
    public IProduct1 getProduct1() {
        return new Product1B();
    }

    @Override
    public IProduct2 getProduct2() {
        return new Product2B();
    }

}

