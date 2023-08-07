package com.zhengxifeng.java;

/**
 *
 * 使用同步方法来解决实现Runnable接口的线程安全问题
 *
 * 关于同步方法的总结：
 * 1. 同步方法仍然涉及到同步监视器，只是不需要我们显式的声明。
 * 2. 非静态的同步方法，同步监视器为： this（当前类的对象）
 *    静态的同步方法，同步监视器为 ：当前类的本身（Window4.class）
 * @author shkstart
 * @create 2022-01-04 13:02
 */

class Window3 implements Runnable{

    private int ticket = 100;


    @Override
    public void run() {
        while (true) {
            show();

        }
    }

    public synchronized void show(){//同步监视器：this
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " ：买票，票号为：" + ticket);
            ticket--;
        }
    }

}

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();//

        Thread t1 = new Thread(w);
        t1.setName("窗口1");
        t1.start();
        Thread t2 = new Thread(w);
        t2.setName("窗口2");
        t2.start();
        Thread t3 = new Thread(w);
        t3.setName("窗口3");
        t3.start();


    }
}
