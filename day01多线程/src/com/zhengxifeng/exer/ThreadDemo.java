package com.zhengxifeng.exer;

/**
 *
 * 练习：创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数。
 *
 * @outhor shkstart
 * @create 2021-12-31 20:28
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread01 m1 = new MyThread01();
//        MyThread02 m2 = new MyThread02();
//        m1.start();
//        m2.start();
        //我们可以选择用匿名子类的方式
        //创建Thread类的匿名子类的方式
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();


    }
}
/*
class MyThread01 extends Thread{
    @Override
    public void run() {
        for (int i = 0;i < 100;i++){
            if (i % 2 == 0){//偶数
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
class MyThread02 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){//奇数
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
*/