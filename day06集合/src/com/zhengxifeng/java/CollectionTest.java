package com.zhengxifeng.java;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * Collection接口中声明的方法的测试
 *
 * 结论：
 * 向Collection接口的实现类的对象中添加数据时，要求obj所在类要重写equals().
 *
 * @author shkstart
 * @create 2022-01-13 13:09
 */
public class CollectionTest {

    @Test
    public void test1(){





        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
//        Person p = new Person("Jerry", 20);
//        coll.add(p);
        coll.add(new Person("Jerry", 20));


        //contains(Object obj)
        boolean contains = coll.contains(123);
        System.out.println(contains);


        System.out.println(coll.contains(new String("Tom")));
//        System.out.println(coll.contains(p));//true

        System.out.println(coll.contains(new Person("Jerry", 20)));//false -->  treu


        //2.containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中。

        Collection coll1 = Arrays.asList(123,4567);

        System.out.println(coll.containsAll(coll1));


    }

    @Test
    public void test2(){

        //3.remove(Object obj)：从当前集合中移除obj元素。   删除成功
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);
        coll.remove(1234);
        System.out.println(coll);
        coll.remove(new Person("Jerry", 20));
        System.out.println(coll);


        //4. removeAll(Collection coll1):差集 ：从当前集合中移除coll1中所有的元素

        Collection coll1 = Arrays.asList(123,456);
        coll.removeAll(coll1);
        System.out.println(coll );




    }


    @Test
    public void tset3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);


        //5.retainAll(): 交集：获取当前集合和coll1集合的交集，并返回给当前集合
        //求交集

//        Collection coll1 = Arrays.asList(123,456,789);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //6.equals(Oject obj):要想返回true ，需要当前集合和形参集合元素都相同。
        Collection coll1 = new ArrayList();//有序的
        coll1.add(456);
        coll1.add(123);
        coll1.add(new Person("Jerry", 20));
        coll1.add(new String("Tom"));
        coll1.add(false);
        System.out.println(coll.equals(coll1));


    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合------> 数组：toArray():

        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            
        }

        //拓展：数组---->集合？:调用Arrays类的静态方法asList()
        List<String> list  = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List<int[]> arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1);
        System.out.println(arr1.size());//1

        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2);
        System.out.println(arr2.size());//2


        //iterator(): 返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java 中测试

    }
}
