package com.zhengxifeng.exer;

/**
 *
 *
 *
 *
 * MyDate类包含：
 * private成员变量 year，month，day；并为每一个属性定义 getter， setter 方法；
 * @author shkstart
 * @create 2022-01-17 19:43
 */
public class MyDate implements Comparable<MyDate>{
    private int year;
    private int minth;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int minth, int day) {
        this.year = year;
        this.minth = minth;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMinth() {
        return minth;
    }

    public void setMinth(int minth) {
        this.minth = minth;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", minth=" + minth +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate m) {
            //比较年
            int minusYear = this.getDay() - m.getDay();
            if (minusYear != 0 ){
                return minusYear;
            }
            //比较月
            int minusMonth = this.getMinth() - m.getMinth();
            if (minusMonth != 0){
                return minusMonth;
            }
            //比较日
            return this.getDay() - m.getDay();
    }


//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof MyDate){
//            MyDate m1 = (MyDate) o;
//            //比较年
//            int minusYear = this.getDay() - m1.getDay();
//            if (minusYear != 0 ){
//                return minusYear;
//            }
//            //比较月
//            int minusMonth = this.getMinth() - m1.getMinth();
//            if (minusMonth != 0){
//                return minusMonth;
//            }
//            //比较日
//            return this.getDay() - m1.getDay();
//        }
//
//        throw new RuntimeException("传入的数据类型不一至");
//
//
//    }
}
