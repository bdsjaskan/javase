package com.zhengxifeng.exer;

/**
 *
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完钱打印账户余额。
 *
 *
 *  1.是否是多线程问题?  是，两个储户线程
 *  2.是否有共享数据?  有账户(或账户余额)
 *  3.是否有线程安全问题?  有
 * 4 .需要考虑如何解决线程安全问题?  同步机制
 * @author shkstart
 * @create 2022-01-04 19:50
 */

class Account{//账户
    private double balance;//余额
    public Account(double balance){
        this.balance = balance;
    }
    //存钱方法
    public synchronized void deposit(double amt){
        if (amt > 0){
            balance += amt;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "：存钱成功，余额为：" + balance);
        }
    }

}
class Customer extends Thread{
    Account acct;
    public Customer(Account acct){
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);
        c1.setName("甲");
        c2.setName("乙");
        c1.start();
        c2.start();
    }
}
