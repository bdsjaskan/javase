package com.zhengxifeng.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2022-01-14 22:25
 */
public class ForTest {
    public static void main(String[] args) {


    }

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);


        //for(集合元素的类型 局部变量 : 集合对象)
        //内部仍然调用了迭代器
        for (Object obj: coll){//相当于把coll集合对象中的内容  用obj 来盛装
            System.out.println(obj);
        }

    }
    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        //for(数组元素的类型 局部变量 : 数组对象)

        for (int i : arr){
            System.out.println(i);
        }
    }

    //练习题
    @Test
    public void test3(){
        String[] str = new String[]{"MM","MM","MM"};


//        //方式一：普通for赋值
//        for (int i = 0; i < str.length; i++) {
//            str[i] = "GG";
//
//        }




        //增强for循环赋值
        for (String str1 : str){
            str1 = "GG";
        }


        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);

        }


    }


    @Test
    public void test8(){
        //System.out.println("请输入本次要检验的字符串个数：");
        Scanner scanner = new Scanner(System.in);
        int i1 = scanner.nextInt();
        int i2 = scanner.nextInt();


        int s = scanner.nextInt();

        int[] str = new int[i1];
        for(int i = 0; i < str.length; i++){
            //System.out.println("请输入一个字符串：");
            //Scanner scanner1 = new Scanner(System.in);
            str[i]  = scanner.nextInt();
            if (i2 - str[i] <= 0){
                System.out.println(1);
            }

        }
        if (i2 > 0){
            System.out.println(-1);
        }

    }
}


