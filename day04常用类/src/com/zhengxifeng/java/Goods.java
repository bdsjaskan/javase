package com.zhengxifeng.java;

/**
 * @author shkstart
 * @create 2022-01-10 20:10
 */
public class Goods implements Comparable{//商品类
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


    //指明商品比较大小的方式
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods){
            Goods goods = (Goods) o;
            //方式一：
            if (this.price > goods.price){
                return 1;
            }else if (this.price < goods.price){
                return -1;

            }else {
                return 0;
            }
            //方式二：
//            return Double.compare(this.price,goods.price);
        }
        throw new RuntimeException("传入的数据类型不一致");

    }
}
