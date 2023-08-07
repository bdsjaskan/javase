package com.zhengxifeng.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 解决线程安全问题的方式三：Lock锁 --- JDK5.0新增
 *
 * 1.面试题synchronized 与 Lock的异同？
 *   相同：二者都能解决线程不安全问题。
 *   不同：synchronized 机制，是在执行完相应的同步代码块后，自动释放同步监视器
 *        lock 需要手动去启动同步（lock()），同时结束同步也需要手动的实现（unlock()）
 *
 * 2.优先使用顺序：
 *  Lock -> 同步代码块（已经进入了方法体，分配了相应的资源） -> 同步方法（在方法体之外）
 *
 *  面试题：如何解决线程安全问题，有几种方式？4
 *
 * @author shkstart
 * @create 2022-01-04 19:05
 */
class Window implements Runnable{
    private int tick = 100;
    //1.实例化 ReentrantLock
    private ReentrantLock lock = new ReentrantLock();//里面有    有参（true   公平的线程（先进先出，先来先执行））  与  无参（默认false  不公平的线程）  构造器
    @Override
    public void run() {
        while (true){
            try{
                //进行上锁
                //调用锁定方法 lock()
                lock.lock();//

                if (tick > 0){
                    System.out.println(Thread.currentThread().getName() + ":" + tick);
                    tick--;
                }else{
                    break;
                }
            }finally {
                //一定执行的代码
                //调用解锁方法 unlock()
                lock.unlock();
            }

        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();//



        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();//启动线程
        t2.start();
        t3.start();



    }

}
