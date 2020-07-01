package com.spiderman.basis._proxy._static;

/**
 * 代理demo
 * <p>具体说明</p>
 *
 * @author Spiderman
 * @version 1.0: com.spiderman.basis._proxy.MyStaticProxy,v 0.1 2020-01-13 16:42 Exp $$
 */
public class MyProxy {
    public static void main(String[] args) {
        Subject staticProxy = SubjectStaticFactory.getInstance();
        staticProxy.dealTask("DBQueryTask");

    }
}

/**
 * 代理接口。处理给定名字的任务。
 */
interface Subject {
    /**
     * 执行给定名字的任务。
     *
     * @param taskName 任务名
     */
    void dealTask(String taskName);
}

/**
 * 真正执行任务的类，实现了代理接口。
 */
class RealSubject implements Subject {

    /**
     * 执行给定名字的任务。这里打印出任务名，并休眠500ms模拟任务执行了很长时间
     *
     * @param taskName
     */
    @Override
    public void dealTask(String taskName) {
        System.out.println("正在执行任务：" + taskName);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

/**
 * 　代理类，实现了代理接口。
 */
class ProxySubject implements Subject {
    //代理类持有一个委托类的对象引用
    private Subject delegate;

    public ProxySubject(Subject delegate) {
        this.delegate = delegate;
    }

    /**
     * 将请求分派给委托类执行，记录任务执行前后的时间，时间差即为任务的处理时间
     *
     * @param taskName
     */
    @Override
    public void dealTask(String taskName) {
        long stime = System.currentTimeMillis();
        //将请求分派给委托类处理
        delegate.dealTask(taskName);
        long ftime = System.currentTimeMillis();
        System.out.println("执行任务耗时" + (ftime - stime) + "毫秒");

    }

}

/**
 * 生成静态代理类工厂
 */
class SubjectStaticFactory {
    //客户类调用此工厂方法获得代理对象。
    //对客户类来说，其并不知道返回的是代理类对象还是委托类对象。
    public static Subject getInstance() {
        return new ProxySubject(new RealSubject());
    }
}

