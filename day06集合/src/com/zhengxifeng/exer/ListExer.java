package com.zhengxifeng.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 *
 * @author shkstart
 * @create 2022-01-16 20:29
 */
public class ListExer {
    /*
    区分list中remove(int index) 和 remove(Object obj)
     */
    @Test
    public void test(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }

//    public static String testZxfZxf(String str){
//        char[] ch = str.toCharArray();
//        int start = 0;
//        int end = ch.length;
//        while (start < end){
//            char chr = ch[start];
//            ch[start] = ch[end];
//            ch[end] = chr;
//            start++;
//            end--;
//        }
//        return String.valueOf(ch);
//    }
    @Test
    public void test000000000000000000000000(){
        String str = "hello";
        String test = ListExer.testZxfZxf(str);
        System.out.println("test = " + test);

    }
    private static String testZxfZxf(String str) {
        char[] ch = str.toCharArray();
        int start = 0;
        int end = ch.length - 1;
        while (start < end){
            char chr = ch[start];
            ch[start] = ch[end];
            ch[end] = chr;
            start++;
            end--;
        }
        return String.valueOf(ch);
    }

    @Test
    public void test00000000000(){
        String str = "Hello, World!";
        StringBuffer result = new StringBuffer();
        List list = new ArrayList();
        char[] cs = str.toCharArray();
        for(int i=0; i<cs.length; i++){
            if(!list.contains(cs[i])){   //不包含  false
                result.append(cs[i]);
                list.add(cs[i]);
            }
        }
        System.out.println("result.toString() = " + result.toString());


        char[] charArray = str.toCharArray();
        Set<Character> charSet = new LinkedHashSet<>();
        for (char c : charArray) {
            charSet.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : charSet) {
            sb.append(c);
        }
        String deduplicatedStr = sb.toString();
        System.out.println("deduplicatedStr = " + deduplicatedStr);

    }

    public void updateList(List list){
        list.remove(2);
//        list.remove(new Integer (2));
    }


}
