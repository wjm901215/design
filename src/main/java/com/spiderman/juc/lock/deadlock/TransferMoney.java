package com.spiderman.juc.lock.deadlock;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 模拟银行转账
 */
public class TransferMoney implements Runnable {

    int flag;
    static Account a = new Account(1,500);
    static Account b = new Account(2,500);

    static class Account {

        public Account(int id,int balance) {
            this.id=id;
            this.balance = balance;
        }

        int balance;

        Integer id;
    }

    @Override
    public void run() {
        if (flag == 1) {
            transferMoney(a, b, 200);
        }
        if (flag == 0) {
            transferMoney(b, a, 200);
        }
    }

    public static void transferMoney(Account from, Account to, int amount) {
        //先获取两把锁，然后开始转账
        List<Account> list=new ArrayList<Account>(){{
            add(from);
            add(to);
        }};
        System.out.println(Thread.currentThread().getName()+"：from-before："+list.get(0).id+"：to-before："+list.get(1).id);
        list.sort(Comparator.comparing(o -> o.id));
        System.out.println(Thread.currentThread().getName()+"：from-after："+list.get(0).id+"：to-after："+list.get(1).id);
        synchronized (list.get(0)) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (list.get(1)) {
                if (from.balance - amount < 0) {
                    System.out.println("余额不足，转账失败。");
                    return;
                }
                from.balance -= amount;
                to.balance += amount;
                System.out.println("成功转账" + amount + "元");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TransferMoney r1 = new TransferMoney();
        TransferMoney r2 = new TransferMoney();
        r1.flag = 1;
        r2.flag = 0;
        Thread t1 = new Thread(r1, "t1");
        Thread t2 = new Thread(r2, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("a的余额" + a.balance);
        System.out.println("b的余额" + b.balance);
    }
}
