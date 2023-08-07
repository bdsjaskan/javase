package com.zhengxifeng.java;

/**
 *
 * 例子：创建三个窗口买票，总票数100张 使用实现Runnable接口的方式
 *
 * @outhor shkstart
 * @create 2022-01-01 17:40
 */

class Window1 implements Runnable{
    private int ticket = 100;//这种方法不用static也可以因为只创建了一次Window1类的对象
    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName() + " ：买票，票号为：" + ticket);
                ticket--;
            }else{
                break;
            }
        }

    }
}
public class WindowTest1 {
    public static void main(String[] args) {
        Window window1 = new Window();

        Thread thread1 = new Thread(window1);
        thread1.setName("窗口1");
        thread1.start();
        Thread thread2 = new Thread(window1);
        thread2.setName("窗口2");
        thread2.start();
        Thread thread3 = new Thread(window1);
        thread3.setName("窗口3");
        thread3.start();

    }


}
