package com.zhengxifeng.java2;

import com.zhengxifeng.java1.Person;
import org.junit.Test;

import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 *
 * 获取当前运行时类的属性结构
 * @author shkstart
 * @create 2022-02-12 13:23
 */
public class FieldTest {

    @Test
    public void test1(){
        Class clazz = Person.class;


        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为Public 访问权限的属性

        Field[] fields = clazz.getFields();//s所有的属性
        for (Field f : fields){
            System.out.println(f);
        }
        System.out.println();
        //getDeclaredFields():获取当前运行时类当中声明的所有属性。（不包含父类中声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields){
            System.out.println(f);
        }


    }

    //权限修饰符、数据类型、变量名
    @Test
    public void test2(){
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields){
            //1.权限修饰符

            int modifiers = f.getModifiers();
//            System.out.println(modifiers);
            System.out.print(Modifier.toString(modifiers) + "\t");


            //2.数据类型

            Class type = f.getType();
            System.out.print(type.getName() + "\t");

            //3.变量名
            String name = f.getName();
            System.out.print(name);


            System.out.println();
        }
    }
}
