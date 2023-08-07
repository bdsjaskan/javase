package com.zhengxifeng.java;

/**
 *
 * 多线程的创建，方式一：继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写thread类中的run()方法  -->将此线程执行的操作声明在run()中
 * 3.创建Thread类的子类对象
 * 4.通过此对象调用start()
 *
 *
 * 例子：遍历所有100以内的偶数
 * @outhor shkstart
 * @create 2021-12-31 19:18
 */


//1.  创建一个继承于Thread类的子类
class MyThread extends Thread{
    //2.重写Thread类的run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
////////////////Thread.currentThread().getName() 这个表示获取当前线程的名字！
public class ThreadTest {//测试类
    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread t1 = new MyThread();

        //4.通过此对象调用start():① 启用当前线程。 ② 调用当前线程run()。
        t1.start();
        t1.run();//问题一：如果我们不调用start()方法还算多线程吗？答：不算

        //问题：在启动一个线程，遍历100以内的偶数。答：不可以！需要让已经start()的线程去执行。会报异常
//        t1.start();
        // 我们需要重新再建造一个对象
        MyThread t2 = new MyThread();
        t2.start();
        //以下是主线程运行的代码！
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + ":" + i + "****main()****");
        }

//        System.out.println("hello");
    }
}








