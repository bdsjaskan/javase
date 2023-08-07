package com.zhengxifeng.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 *
 *
 * 面试题：Collection 与 Collections 有什么不同？
 *
 *
 * @author shkstart
 * @create 2022-01-21 20:52
 */
public class CollectionsTest {
    /*
    排序操作：（均为static方法）
    reverse(List)：反转 List 中元素的顺序
    shuffle(List)：对 List 集合元素进行随机排序
    sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
    sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
    swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换


    查找、替换
    Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
    Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回
    给定集合中的最大元素
    Object min(Collection)
    Object min(Collection，Comparator)
    int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
    void copy(List dest,List src)：将src中的内容复制到dest中
    boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换
    List 对象的所有旧值
     */
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        //错误的  报异常IndexOutOfBoundsException
//        List dest = new ArrayList();
//        Collections.copy(dest, list );


        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size()); // list.size();
        Collections.copy(dest, list );
        System.out.println(dest);



        /*
        Collections 类中提供了多个 synchronizedXxx() 方法，
        该方法可使将指定集合包装成线程同步的集合，
        从而可以解决多线程并发访问集合时的线程安全问题

         */

        //返回的list1 即为线程安全的list
        List list1 = Collections.synchronizedList(list);
    }

    @Test
    public void test(){
        List list = new ArrayList();

        list.add(123);
        list.add(43);
        list.add(765);
        list.add(765);
        list.add(765);
        list.add(-97);
        list.add(0);

        System.out.println(list);
//        Collections.reverse(list);

//        Collections.shuffle(list);

//        Collections.sort(list);

//        Collections.swap(list,1,2);

//        int frequency = Collections.frequency(list, 765);
//        System.out.println(frequency);


        System.out.println(list);



    }
}
