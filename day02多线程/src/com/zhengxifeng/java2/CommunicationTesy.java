package com.zhengxifeng.java2;

/**
 *
 * 线程通信的例子：使用两个线程打印 1-100.线程1，线程2 交替打印
 *
 * 涉及到三个方法：
 * wait():一旦执行此方法，该线程就进入堵塞状态，并释放同步器监视器
 * notify():一旦执行此方法，就会唤醒一个被wait的一个线程。如果有多个线程被wait  就唤醒优先级较高的线程
 * notifyAll():一旦执行此方法，就会唤醒所有被wait的线程。
 *
 * 说明：
 * 1.wait()，notify()，notifyAll()  三个方法必须使用在同步代码块或同步方法中
 * 2.三个方法的调用者   必须是同步代码块（同步方法）中的同步监视器。否则，会出现异常
 * 3.三个方法都是定义在Object中的方法
 * @author shkstart
 * @create 2022-01-04 20:41
 */
class Number implements Runnable{
    private int number = 1;
    private Object obj = new Object();
    @Override
    public void run() {
        while (true){
            synchronized (obj){
                obj.notify();//唤醒

                if (number <= 100){

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                    try {
                        obj.wait();//使得调用如下wait()方法的线程进入阻塞状态   会释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}

public class CommunicationTesy {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();

    }


}
