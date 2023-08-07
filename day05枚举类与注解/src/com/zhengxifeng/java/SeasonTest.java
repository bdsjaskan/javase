package com.zhengxifeng.java;

/**
 * 一、枚举类的使用
 * 1.枚举类的理解：  类的对象只有有限个，确定的。我们称此类为枚举类
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.如果 枚举类中只有一个对象，则可以作为单例模式的实现方式 。
 *
 *
 * 二、如何定义枚举类
 * 方式一：jdk5.0之前，自定义枚举类
 * 方式二：jdk5.0时，可以使用enum关键字定义枚举类
 *
 * 三、 Enum类中的常用方法：
 *      values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 *      valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象
 *      toString()：返回当前枚举类对象常量的名称
 *
 *
 * 四、使用enum关键字定义的枚举类实现接口的情况
 *      情况一：实现接口，在enum类中实现抽象方法
 *      情况二：让枚举类的对象分别实现接口中的抽象方法
 * @author shkstart
 * @create 2022-01-11 14:14
 */
public class SeasonTest{
    public static void main(String[] args) {
        Season spring = Season.SPRING;

        System.out.println(spring);
    }

}
//自定义枚举类
class Season{
    //声明Season对象的属性 : private final修饰
    private final String seasonname;
    private final String seasonDesc;

    //1.私有化构造器
    public Season(String seasonname, String seasonDesc){
        this.seasonDesc = seasonDesc;
        this.seasonname =seasonname;

    }
    //3.提供当前枚举类的多个对象
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冰天雪地");

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
}
