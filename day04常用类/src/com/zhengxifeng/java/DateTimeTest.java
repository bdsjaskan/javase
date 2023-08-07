package com.zhengxifeng.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * jdk 8 之前的日期时间的API测试
 * 1. System类中的currentTimeMillis();
 * 2. java.util.Date和子类 java.sql.Date
 * 3. SimpleDateFormat
 * 4. Calendar
 * @author shkstart
 * @create 2022-01-09 13:47
 */
public class DateTimeTest {
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作：
    1.1 格式化： 日期 ---> 字符串
    1.2 解析：   格式化的逆过程，  字符串 ---> 日期

    2.SimpleDateFormat的实例化
     */

    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期 --> 字符串
        Date date = new Date();
        System.out.println(date);//默认的

        String format = sdf.format(date);
        System.out.println(format);


        //解析： 格式化的逆过程，字符串 ---> 日期
        String str = "22-1-9 下午7:00";
        Date date1 = sdf.parse(str);
        System.out.println(date1);


        //***********************按照指定的方式格式化和解析：调用带参数的构造器********************************************
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        //格式化
        String format1 = sdf2.format(date);
        System.out.println(format1);//2022-01-09 07:11:05
        //解析： 要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器参数体现）
        // 否则 会抛出异常
        Date date2 = sdf2.parse("2023-01-09 07:11:05");
        System.out.println(date2);




    }
 /*
        练习一：字符串"2020-09-08"转换为 java.sql.Date
         */
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);
        System.out.println(date);
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);

    }
    /*
    Calendar日历类的使用
     */
    @Test
    public void testCalendar(){
        //1.实例化
        //方式一： 创建其子类（GregorianCal）的对象
        //方式二： 调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));//今年第几天


        //set()

        calendar.set(Calendar.DAY_OF_MONTH,22);//设置为第几天
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        //add()
        calendar.add(Calendar.DAY_OF_MONTH,3);//+3天  要是想减去3天就填写 -3
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);


        //getTime()：日历类---> Date
        Date date = calendar.getTime();
        System.out.println(date);//

        //setTime(): Date---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);

        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);


    }



}
