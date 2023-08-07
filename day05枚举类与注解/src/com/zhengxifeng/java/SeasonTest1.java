package com.zhengxifeng.java;

/**
 * 使用enum关键字定义枚举类
 * 说明: 定义的枚举类继承于java.long.Enum类
 * @author shkstart
 * @create 2022-01-11 19:05
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        //toString()方法
        Season1 summer = Season1.SUMMER;
        System.out.println(summer.toString());
        System.out.println(Season1.class.getSuperclass());
        System.out.println("*************************************");
        //values():返回所有的枚举类对象构成的数组
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }

        System.out.println("********************************");
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);

        }
        System.out.println("********************************");
        //valueOf(String objName):返回枚举类中对象名是objName的对象。如果
        //如果没有objName的枚举类对象则抛出异常。
        Season1 autumn = Season1.valueOf("AUTUMN");
//        Season1 autumn1 = Season1.valueOf("AUTUMN1");//错误的
        System.out.println(autumn);
        autumn.show();




    }

}

interface InFo{
    void show();
}
//使用enum定义枚举类
enum Season1 implements InFo{
    //1.提供当前枚举类的对象   多个对象用, 分开  末尾用 ;

    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };



    //声明Season对象的属性 : private final修饰
    private final String seasonname;
    private final String seasonDesc;

    //1.私有化构造器
    private Season1(String seasonname, String seasonDesc){
        this.seasonDesc = seasonDesc;
        this.seasonname =seasonname;

    }

    //4.其他诉求1：获取枚举类对象的属性


    public String getSeasonname() {
        return seasonname;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    //5.其他诉求2：提供toString()方法

    @Override
    public String toString() {
        return "Season{" +
                "seasonname='" + seasonname + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

    @Override
    public void show() {
        System.out.println("这是一个季节!");
    }
}
