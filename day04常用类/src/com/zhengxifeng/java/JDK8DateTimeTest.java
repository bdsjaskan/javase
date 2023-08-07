package com.zhengxifeng.java;

import org.junit.Test;

import java.text.Format;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 *
 * jdk 8 中日期时间API的测试
 * @author shkstart
 * @create 2022-01-09 21:36
 */
public class JDK8DateTimeTest {

    @Test
    public void testDate(){
        //偏移量
        Date date1 = new Date(2020 - 1900,9 - 1,8);
        System.out.println(date1);

    }


    /*
    LocalDate、LocalTime、LocaDateTime 的使用

    说明：
        1.LocaldateTime相较于LocalDate、LocalTime，使用频率要高
        2.类似于Calendar
     */
    @Test
    public void test1(){
        //now()获取当前的日期 、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of(): 设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);

        System.out.println(localDateTime1);

        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //体现不可变性
        //withXxx(): 设置相关的属性

        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        //
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);

    }

    /*
       Instant的使用
       类似于：java.util.Date类
     */
    @Test
    public void test2(){

        //now(): 获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);//2022-01-09T14:30:23.867Z

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2022-01-09T22:30:23.867+08:00

        //获取对应的毫秒数（1970年1月1日0时0分0秒（UTC）开始的毫秒数）----> 有点像 Date 类的 getTime()方法。
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli(): 通过给定的毫秒数，获取Instant 实例  --> 有点像 Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1641738895414L);
        System.out.println(instant1);


    }
    /*

     DateTimeFormatter：格式化或解析日期、时间
     类似于SimpleDateFormat
     */

    @Test
    public void test3(){
//        方式一： 预定义的标准格式。如: ISO_ LOCAL DATE_ TIME;ISO_ LOCAL_ DATE;ISO_ LOCAL_ TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化：日期 ---> 字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);
        //解析：字符串 --> 日期
        TemporalAccessor parse = formatter.parse("2022-01-09T22:52:03.266");
        System.out.println(parse);


//        方式二： 本地化相关的格式。如: ofLocal izedDateTime(FormatStyle. LONG)
        //本地化相关的格式。如: ofLocalizedDateTime()
        //formatStyle. LONG / FormatStyle. MEDIUM / FormatStyle. SHORT :适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);//22-1-9 下午11:00
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);


        //本地化相关的格式。如: ofLocalizedDate()
        //FormatStyle. FULL / FormatStyle. LONG / FormatStyle. MEDIUM / FormatStyle.SHORT :

        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        //格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);//2022年1月9日 星期日
        //



//      重点:  方式三： 自定义的格式。如: ofPattern( “yyyy-MM-dd hh:mm:ss E")
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);
        //解析
        TemporalAccessor parse1 = formatter3.parse("2022-01-09 11:07:10");
        System.out.println(parse1);


    }

}
