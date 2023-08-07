package com.zhengxifeng.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author shkstart
 * @create 2022-01-19 12:31
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(343);
        coll.add(343);
        coll.forEach(System.out::println);

    }
}
