package com.zhengxifeng.java1;

import java.io.Serializable;

/**
 * @author shkstart
 * @create 2022-02-12 13:04
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }
    public void eat(){
        System.out.println("生物吃东西");
    }

}
