package com.zhengxifeng.java2;

/**
 * 线程通信的应用:经典例题:生产者/消费者问题
 * 生产者(Productor)将产品交给店员(CLerk),而消费者(Customer)从店员处取走产品,
 * 店员一次只能持有固定数量的产品(比如:20)，如果生产者试图生产更多的产品，店员
 * 会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产;如果店中没有产品
 * 了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 * 分析:
 * 1.是否是多线程问题?   是，生产者线程，消费者线程
 * 2.是否有共享数据?   是，店员(或产品)
 * 3.如何解决线程的安全问题?  同步机制,有三种方法
 * 4.是否涉及线程的通信?   是
 *
 *
 *
 * @author shkstart
 * @create 2022-01-05 9:28
 */

class Clerk{
    private int hzxh = 0;


    public synchronized void produceProduct() {//生产
        if (hzxh < 20){
            hzxh++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + hzxh + "个产品");
            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumerProduct() {//消费
        if (hzxh > 0){
            System.out.println(Thread.currentThread().getName() + "开始消费第" + hzxh + "个产品");
            hzxh--;
            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Producer extends Thread{//生产者
    private Clerk clerk;

    Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始生产产品......");
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();


        }



    }
}
class Consumer extends Thread{//消费者
    private Clerk clerk;

    Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始消费产品......");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true){

            clerk.consumerProduct();

        }

    }
}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        p1.setName("生产者");
        p1.start();
        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者1");
        c1.start();
        Consumer c2 = new Consumer(clerk);
        c2.setName("消费者2");
        c2.start();
    }
}





