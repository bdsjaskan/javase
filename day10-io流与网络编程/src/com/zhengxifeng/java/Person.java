package com.zhengxifeng.java;

import java.io.Serializable;

/**
 * 需要满足下列条件，方可序列化
 * 1.实现 Serializable 接口
 *
 * 2.提供一个全局常量 ：serialVersionUID = 45984233L;  数值不做要求
 *
 * 3.除了Person 需要实现Serializable之外 ，还要保证其内部的所有属性也必须是可序列化的。
 * （默认下 基本数据类型也是可序列化的）
 *
 *
 * 补充：  ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员
 * @author shkstart
 * @create 2022-02-06 19:52
 */
public class Person implements Serializable {
    public static final long serialVersionUID = 4587321897L;
    private String name;
    private int age;
    private int id;
    private Account acct;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, Account acct) {
        this.name = name;
        this.age = age;
        this.acct = acct;
    }

    public Person(String name, int age, int id, Account acct) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.acct = acct;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAcct() {
        return acct;
    }

    public void setAcct(Account acct) {
        this.acct = acct;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", acct=" + acct +
                '}';
    }
}

class Account implements Serializable{
    public static final long serialVersionUID = 458976545648L;
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
