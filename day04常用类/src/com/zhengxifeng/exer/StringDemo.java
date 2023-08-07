package com.zhengxifeng.exer;

import org.junit.Test;

/**
 * @author shkstart
 * @create 2022-01-08 20:42
 */
public class StringDemo {
    /*
    将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为“abfedcg”。
     */
    //方式一：转换为char[]
    public String reverse(String str, int startIndex, int endIndex){
        if (str != null){
            char[] arr = str.toCharArray();
            for (int x = startIndex, y = endIndex;x < y;x++, y-- ){
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;

    }


    //方式二：使用String的拼接
    public String reverse1(String str, int startIndex, int endIndex){
        if (str != null) {
            //1.转换之前的那部分
            String reverseStr = str.substring(0, startIndex);//左开右闭
            //2.转换  中间部分
            for (int i = endIndex; i >= startIndex; i--) {
                reverseStr += str.charAt(i);
            }
            //3.转换之后的那部分
            reverseStr += str.charAt(endIndex + 1);
            return reverseStr;
        }
        return null;
    }
    //方式三：（优化）用StringBuffer或StringBuilder 的拼接。
    public String reverse2(String str, int startIndex, int endIndex){
        if (str != null) {
            StringBuilder builder = new StringBuilder(str.length());

            //1.

            builder.append(str.substring(0, startIndex));
            //2.
            for (int i = endIndex; i >= startIndex; i--) {
                builder.append(str.charAt(i));
            }
            //3.
            builder.append(str.substring(endIndex + 1));
            return new String(builder);
        }
        return null;
    }



    @Test
    public void test1(){
        String str = "abcdefg";
        String reverse = reverse2(str, 2, 5);
        System.out.println(reverse);

    }
}
