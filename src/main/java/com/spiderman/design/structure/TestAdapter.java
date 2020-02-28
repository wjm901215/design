package com.spiderman.design.structure;

/**
 * 适配器模式
 * 定义：将一个类的接口转换成客户希望的另外一个接口，Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 * <p>
 * 角色：适配器（Adapter）、被适配类、对象（Adaptee）
 * <p>
 * 理解：客户需要Target，现实只有Adaptee，可以用一个实现Target协议的适配器通过类继承或者对象组合类获得被Adaptee。
 */
public class TestAdapter {
    public static void main(String[] args) {
        // 原来是IOrigin接口但是不符合我要求，所以用ITarget适配一下
        ITarget target = new Target();
        target.newDeal(1);
        target.newDeal(0);
    }
}

// 原有的接口，不符合客户要求
interface IOrigin {
    void deal();
}

class Origin implements IOrigin{

    @Override
    public void deal() {
        System.out.println("IOrigin");
    }
}
// 定义一个符合客户要求的新接口
interface ITarget {
    void newDeal(int type);
}

class Target implements ITarget {
    private IOrigin origin=new Origin();

    @Override
    public void newDeal(int type) {
        if (type == 0) {
            origin.deal();
        } else {
            //做其他
            System.out.println("newOrigin");
        }
    }
}

