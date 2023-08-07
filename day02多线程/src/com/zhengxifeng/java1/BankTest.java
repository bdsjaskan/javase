package com.zhengxifeng.java1;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @author shkstart
 * @create 2022-01-04 13:51
 */
public class BankTest {


}
class Bank{

    private Bank(){}
    private static Bank instance = null;

    public static Bank getInstance(){//同步监视器：当前类
//        synchronized(Bank.class){//方式一：效率比较低
//            if (instance == null){
//                instance = new Bank();
//            }
//            return instance;
//        }
//
        if (instance == null){//方式二：效率更高
            synchronized(Bank.class){
                if (instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }

}







