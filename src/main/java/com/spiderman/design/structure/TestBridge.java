package com.spiderman.design.structure;

/**
 * 桥接模式
 * 定义：将抽象部分与它的实现部分分离，使它可以独立的变更
 *
 * 角色：抽象层接口（Abstraction）、具体抽象层、实现者接口、具体实现者。
 */
public class TestBridge {
    public static void main(String[] args) {
        Iphone iphone=new Iphone();
        iphone.setMemory(new Memory4g());
        iphone.buyPhone();
        System.out.println("-------");
        XiaoMi xiaoMi=new XiaoMi();
        xiaoMi.setMemory(new Memory8g());
        xiaoMi.buyPhone();
    }
}

/**
 * 手机抽象类
 */
abstract class Phone {
    public Memory memory;

    public void setMemory(Memory memory) {
        this.memory = memory;
    }
    public abstract void buyPhone();
}

class Iphone extends Phone{

    @Override
    public void buyPhone() {
        memory.addMemory();
        System.out.println("购买了苹果手机");
    }
}
class XiaoMi extends Phone{

    @Override
    public void buyPhone() {
        memory.addMemory();
        System.out.println("购买了小米手机");
    }
}

/**
 * 内存接口
 */
interface Memory{
    void addMemory();
}

/**
 * 4G内存
 */
class Memory4g implements Memory{

    @Override
    public void addMemory() {
        System.out.println("新增4G存储");
    }
}

/**
 * 8G内存
 */
class Memory8g implements Memory{

    @Override
    public void addMemory() {
        System.out.println("新增8G存储");
    }
}