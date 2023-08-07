package com.zhengxifeng.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-01-23 22:06
 */
public class SubOrder extends Order<Integer>{


    public static  <E> List<E> copyFromArrayToList(E[] arr){
    ArrayList<E> list = new ArrayList<>();
    for (E e : arr){
        list.add(e);
    }
    return list;

}
}
