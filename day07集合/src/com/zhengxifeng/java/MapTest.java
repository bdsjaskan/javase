package com.zhengxifeng.java;

import org.junit.Test;

import java.util.*;

/**
 *
 *一、 Map的实现类的结构：
 * /----Map：双列数据，存储key-value键值对的数据 ----类似于高中的函数 ： y = f(x)
 *          /----HashMap: 作为Map主要实现类 线程不安全，效率高;  可以存储null 的key 和 value
 *               /----LinkedHashMap: 保证在遍历map元素时；可以按照元素添加时的顺序实现遍历。
 *                                   原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 *                                   对于频繁的遍历操作，此类执行效率高于HashMap
 *          /----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
 *                       底层使用红黑树
 *
 *          /----Hashtable: 作为古老实现类  线程安全的， 效率低；不可以存储null 的key 和 value
 *               /----Properties: 常用来处理配置文件。key 和 value 都是 String 类型
 *
 *
 *          HashMap的底层：数组 + 链表 （jdk7.0）
 *                        数组 + 链表 + 红黑叔 （jdk8.0）
 *
 *   面试题：
 *   1. HashMap的底层实现原理？
 *   2. HashMap 和 Hashtable 的异同？
 *   3. CurrentHashMap 与 Hashtable 的异同？（暂时不讲）
 *
 *
 *   二、Map结构的理解：
 *      Map中的key：无序的、不可重复的，使用Set存储所有的key ----> key所在的类要重写 equals() 和 hashCode()
 *      Map中的value：无序的、可重复的，使用Collection存储所有的value ----> value 所在类要重写equals()
 *      一个键值对：key - value 构成一个Entry对象。
 *      Map 中的 entry：无序的，不可重复的 ，使用Set存储所有的entry
 *
 *   三、HashMap的底层实现原理？以jdk7为例
 *        HashMap map = new HashMap():
 *        在实例化以后，底层创建了长度是16的一维数组 Entry[] table。
 *        ....可能已经执行过多次put.....
 *        map.put(kry1,value1):
 *        首先，调用kry1所在类的 hashCode() 方法 ，计算key1的哈希值，此哈希值经过某种算法计算以后，得到在entry数组中的存放位置
 *        如果此位置上的数据为空，则 key1 - value1 添加成功： ---->情况一：
 *        如果此位置上的数据不为空  （意味着此位置上有 一个或多个数据（以链表形式存在的））， 比较key1和已经存在的一个或多个数据的哈希值：
 *                  如果key1 的哈希值与已经存在的数据的哈希值都不相同，此时key1 - value 添加成功。 ----> 情况二：
 *                  如果key1 的哈希值与已经存在的某一个数据（key2 - value2）的哈希值相同，则继续比较：调用key1 所在类的equals(key2)
 *                              如果 equals()方法返回 false； 则key1 - value1 添加成功 ----> 情况三：
 *                              如果 equals()方法返回 true；  则使用key1中的value1 替换 key2中的value2.
 *
 *
 *              补充： 关于情况2和情况3 ：此时  key1 - value1 和原来位置上的数据 是以链表形式的方式存储
 *
 *
 *              在不断的添加的过程中，会涉及到扩容的问题，当超出临界值（且要存放的位置非空 ）时，扩容 ，
 *              默认的扩容方式： 扩容为原来容量的2倍，并将原来的数据 复制过来。
 *
 *
 *              jdk8 相较
 *              于jdk7 在底层实现方面的不同：
 *              1. new HashMap():  底层没有创建一个长度为16 的 entry数组
 *              2. jdk8中 底层数组是：Node[] , 而非 Entry[]
 *              3. 首次调用 put() 方法时 ，底层创建长度为16的数组
 *              4. 原来jdk7 底层结构只有：   数组 + 链表
 *                        jdk8 底层结构：   数组 + 链表 + 红黑树
 *
 *                     当数组的某一个索引位置上的元素  以链表形式存在的数据个数 > 8个 且 当前数组长度 > 64时，
 *                     此时索引位置上的所有数据改为红黑树存储。
 *
 *              DEFAULT_INITIAL_CAPCITY :   HashMap的默认容量，16
 *              DEFAULT_LOAD_FACTOR :       HashMap的默认加载因子：0.75
 *              threshold :   扩容的临界值， =  容量  *  加载（填充）因子 :  16 * 0.75 => 12
 *              TREEIFY_THRESHOLD:  Bucket 中链表长度大于该默认值，转化为红黑树：8
 *              MIN_TREEIFY_CAPACITY: 桶中的Node被树化时最小的hash表容量：64
 *
 *
 *
 *   四、LinkedHashMap 的底层实现原理 （了解）
 *          源码中：
 *     static class Entry<K,V> extends HashMap.Node<K,V> {
 *         Entry<K,V> before, after;//能够记录添加的元素的先后顺序
 *         Entry(int hash, K key, V value, Node<K,V> next) {
 *             super(hash, key, value, next);
 *         }
 *     }
 *
 *
 * 五、Map中定义的方法：
 *  添加、删除、修改操作：
 *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *  void putAll(Map m):将m中的所有key-value对存放到当前map中
 *  Object remove(Object key)：移除指定key的key-value对，并返回value
 *  void clear()：清空当前map中的所有数据
 *  元素查询的操作：
 *  Object get(Object key)：获取指定key对应的value
 *  boolean containsKey(Object key)：是否包含指定的key
 *  boolean containsValue(Object value)：是否包含指定的value
 *  int size()：返回map中key-value对的个数
 *  boolean isEmpty()：判断当前map是否为空
 *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *  元视图操作的方法：
 *  Set keySet()：返回所有key构成的Set集合
 *  Collection values()：返回所有value构成的Collection集合
 *  Set entrySet()：返回所有key-value对构成的Set集合
 * Map map = new HashMap();
 * //map.put(..,..)省略
 * System.out.println("map的所有key:");
 * Set keys = map.keySet();// HashSet
 * for (Object key : keys) {
 * System.out.println(key + "->" + map.get(key))
 *
 *
 *
 *  总结：常用方法 ：
 *   添加：put(Object key, Object value)
 *   删除：remove(Object key)
 *   修改：put(Object key, Object value)
 *   查询: get(Object key)
 *   长度：size()
 *   遍历：keySet() / values() / entrySet()
 *
 *
 * @author shkstart
 * @create 2022-01-19 19:43
 */
public class MapTest {
    /*
         元视图操作的方法：
     *  Set keySet()：返回所有key构成的Set集合
     *  Collection values()：返回所有value构成的Collection集合
     *  Set entrySet()：返回所有key-value对构成的Set集合
     */
    @Test
    public void test5(){
        Map map = new HashMap();

        map.put("AA",123);
        map.put(45,1234);
        map.put("BB",456);

        //遍历所有的key集：keySet()
        Set keySet = map.keySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("***********************");
        //遍历所有的value集：values()
        Collection values = map.values();
        for (Object obj : values){
            System.out.println(obj);
        }
        System.out.println("***********************");

        //方式1：
        //遍历所有的 key - value
        //entrySet():
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            //entrySet 集合中的元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }
        System.out.println("22222222222222222222222222");
        //方式2：'
        Set keySet1 = map.keySet();
        Iterator iterator2 = keySet1.iterator();
        while (iterator2.hasNext()){
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "====" + value);

        }
        System.out.println("***********************");




    }

    /*
     元素查询的操作：
     *  Object get(Object key)：获取指定key对应的value
     *  boolean containsKey(Object key)：是否包含指定的key
     *  boolean containsValue(Object value)：是否包含指定的value
     *  int size()：返回map中key-value对的个数
     *  boolean isEmpty()：判断当前map是否为空
     *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
     */
    @Test
    public void test4(){
        Map map = new HashMap();

        map.put("AA",123);
        map.put(45,123);
        map.put("BB",456);
//        Object get(Object key)：获取指定key对应的value
        Object o1 = map.get("BB");
        System.out.println(o1);
//        System.out.println(map.get("dsjk"));//key  不存在的话就是输出null

//        boolean containsKey(Object key)：是否包含指定的key
        boolean isExist = map.containsKey("AA");
        System.out.println(isExist);
//        boolean containsValue(Object value)：是否包含指定的value
        isExist = map.containsValue(456);
        System.out.println(isExist);

//        map.clear();
        System.out.println(map.isEmpty());

        Map map1 = new HashMap();

        map1.put("AA",123);
        map1.put(45,123);
        map1.put("BB",456);


        boolean equals = map.equals(map1);
        System.out.println(equals);


    }


    /*
     *  添加、删除、修改操作：
     *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
     *  void putAll(Map m):将m中的所有key-value对存放到当前map中
     *  Object remove(Object key)：移除指定key的key-value对，并返回value
     *  void clear()：清空当前map中的所有数据
     */

    @Test
    public void test3(){
        Map map = new HashMap();
        //添加
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",456);
        //体现修改
        map.put("AA",87);
        System.out.println(map);

        Map map1 = new HashMap();
        map.put("CC",123);
        map.put("DD",123);



        map.putAll(map1);
        System.out.println(map);


        Object value = map.remove("CC");

        System.out.println(value);

        System.out.println(map);


        map.clear();//与 map = null 操作不同
        System.out.println(map.size());
        System.out.println(map);


    }
    @Test
    public void test2(){
        Map map = new HashMap();

        map = new LinkedHashMap();
        map.put(123,"AA");
        map.put(345,"BB");
        map.put(12,"CC");

        System.out.println(map);

    }

    @Test
    public void test1(){
        Map map = new HashMap();
        map = new Hashtable();
        map.put(123,123);
    }


}
