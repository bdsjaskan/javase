package com.zhengxifeng.java;

/**
 *
 *  使用同步代码块解决继承Thread类的方式的线程安全问题
 *
 *  例子：创建三个窗口卖票，总票数为100张。使用继承Thread类的方式
 *
 *  说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，
 *  考虑使用当前类，来充当同步监视器。
 *
 * @author shkstart
 * @create 2022-01-04 11:41
 */


class Window2 extends Thread{
    private static int ticket = 100;
//    Object obj = new Object();
    private static Object obj = new Object();

    @Override
    public void run() {
        while (true){
            //正确的
//            synchronized (obj){
            synchronized (Window2.class){//Class clazz = Window.class , Window2.class
                //synchronized(this) {  //不唯一（错误的）this代表的t1t2t3  三个对象

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为: " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {


        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}





















