package com.zhengxifeng.java;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * |----Collection接口：单列集合，用来存储一个一个的对象
 *       |----List接口 ：存储有序的、可重复的数据。 -->“动态”数组,替换原有的数组
 *            |----ArrayList：作为list接口的主要实现类：  线程不安全的；效率高；底层使用 Object[] elementData存储
 *            |----LinkedList：对于频繁的插入、删除操作，使用此类效率比ArrayList高； 底层用双向链表存储
 *            |----Vector：作为list接口的古老实现类；线程安全的,效率低； 底层使用 Object[] elementData 存储
 *
 *  2.ArrayList的源码分析:
 *  2.1jdk 7.0 情况下
 *      ArrayList list = new ArrayList();//底层创建了长度为10的Object[] 数组 elementData
 *      list.add(123);//elementData[0] = new Integer(123);
 *      ...
 *      list.add(11);//如果此次的添加操作导致底层elementData数组容量不足，则扩容。
 *      默认情况下，扩容为原来的1.5倍，同时将原来的数组数据复制到新的数组中。
 *
 *      结论：建议开发中使用带参数的构造器：ArrayList list = new ArrayList(int capacity);
 *
 *   2.2 jdk 8.0 中ArrayList 点变化：
 *      ArratList list = new ArrayList(); //底层Object[] elementData 初始化为}{}.并没有创建长度为10的数组
 *      list.add(123);//第一次调用add()时，底层才创建了长度10的数组，并将数组123添加到elementData 数组中
 *      ...
 *      list.add(456);后续的添加操作与jdk7 一样。
 *
 *
 *      list.add(11);//如果此次的添加操作导致底层elementData数组容量不足，则扩容。
 *  *      默认情况下，扩容为原来的1.5倍，同时将原来的数组数据复制到新的数组中。
 *  *
 *  *      结论：建议开发中使用带参数的构造器：ArrayList list = new ArrayList(int capacity);
 *
 *  2.3小结：jdk7 中的ArrayList对象的创建相当于单例模式中的饿汉式，
 *           而jdk8 中的ArrayList对象的创建相当于单例模式中的懒汉式。延迟了数组的创建，节省内存 。
 *
 *
 *
 * 3. LinkedList 的源码分析：
 *      LinkedList list = new LinkedList(); 内部声明了Node 类型的first和last属性，默认值为null；
 *      list.add(123);//将123封装到Node中，创建了Node对象。
 *
 *      其中， Node定义为：体现了LinkedList的双向链表的说法
 *      private static class Node<E> {
 *              E item;
 *              Node<E> next;
 *              Node<E> prev;
 *
 *              Node(Node<E> prev, E element, Node<E> next) {
 *                   this.item = element;
 *                   this.next = next;
 *                   this.prev = prev;
 *             }
 *     }
 *
 *
 *   4. Vector的源码分析：jdk7和jdk8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组
 *      在扩容方面，默认扩容为原来的数组长度的2倍。
 *
 *
 *
 *
 *
 *
 * 面试题：ArrayList 、LinkedList 、 Vector 三者的异同 ？
 * 同：三个类都实现了List接口，存储数据的特点相同：存储有序的、可重复的数据
 *
 * 不同：见上述分析
 *
 * @author shkstart
 * @create 2022-01-16 13:07
 */
public class ListTest {
    /*
    void add(int index, object ele): 在index位置插入ele元素
    boolean addALl(int index, Collection eles): 从 index位置开始将eles中的所有元素添加进来
    Object get(int index): 获取指定index位置的元素
    int indexOf(Object obj): 返回bj在集合中首次出现的位置
    int LastIndex0f(object obj): 返回obj在当前集合中末次出现的位置
    Object remove(int index): 移除指定index位置的元素，并返回此元素
    Object set(int index, object ele):设置指定index位置的元素为eLe
    List sublist(int fromIndex, int toIndex) :返回从fromIndex到toIndex位置的子集合

    总结常用方法 ：

    增：add  addAll
    删：remove(int index)/remove(Object obj)
    改: set(int index, Object obj)
    查: get(int index)
    插: add(int index, Object ele)
    长度: size()
    遍历: ① Iterator 迭代器方式
          ② 增强for循环
          ③ 普通的循环

     */

    @Test
    public void test3(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("aa");

        //方式一：迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("******************************");
        //方式二：增强for循环
        for (Object obj : list){
            System.out.println(obj);
        }
        System.out.println("******************************");
        //方式三：普通for循环
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }


    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("aa");
        list.add(new Person("Tom",12));
        list.add(456);
        System.out.println(list);

        //int indexOf(Object obj): 返obj在集合中首次出现的位置
        int index = list.indexOf(456);
        System.out.println(index);
        //int LastIndex0f(object obj): 返回obj在当前集合中末次出现的位置
        int index1 = list.lastIndexOf(456);
        System.out.println(index1);

        //Object remove(int index): 移除指定index位置的元素，并返回此元素
        Object remove = list.remove(0);
        System.out.println(remove);
        System.out.println(list);

        //Object set(int index, object ele):设置指定index位置的元素为eLe

        list.set(0,123);
        System.out.println(list);

        //List sublist(int fromIndex, int toIndex) :返回从fromIndex到toIndex位置的(左闭右开)子集合

        List subList = list.subList(1, 4);
        System.out.println(subList);
    }


    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("aa");
        list.add(new Person("Tom",12));
        list.add(456);

        System.out.println(list);

        //add(int index, object ele):
        list.add(1,456);
        System.out.println(list);

        //addAll(int index, Collection eles)
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(2,list1);
        System.out.println(list.size());
        System.out.println(list);

        //Object get(int index): 获取指定index位置的元素

        System.out.println(list.get(5));


    }
}
