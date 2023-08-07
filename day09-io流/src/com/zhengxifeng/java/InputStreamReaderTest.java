package com.zhengxifeng.java;

import org.junit.Test;

import java.io.*;

/**
 *
 * 1.转换流：属于字符流
 *
 *  InputStreamReader：  将一个字节的输入流转换为字符的输入流
 *  OutputStreamWriter： 将一个字符的输出流转换为字节的输出流
 *
 * 2.作用：提供字节流与字符流之间的转换
 *
 * 3. 解码： 字节、字节数组 ---> 字符数组、字符串
 *    编码： 字符数组、字符串 ---> 字节、字节数组
 *
 *
 *
 * 4.字符集
 *
 * ASCII:美国标准信息交换码。
 *  用一个字节的7位可以表示。
 * IS08859-1:拉丁码表。欧洲码表
 *  用一个字节的8位表示。
 * GB2312:中国的中文编码表。最多两个字节编码所有字符
 * GBK:中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码.
 * Unicode:国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的
 * 字符码。所有的文字都用两个字节来表示。.
 * UTF-8:变长的编码方式，可用1-4个字节来表示-一个字符。
 *
 *
 *
 *
 * @author shkstart
 * @create 2022-02-01 19:30
 */
public class InputStreamReaderTest {


    /*
    此时处理异常的话，仍然需要使用 try-catch-finally
    InputStreamReader的使用，实现字节的输入流到字符的输入流的转换
     */
    @Test
    public void test1() throws IOException {


        //基础的输入流  节点流
        FileInputStream fis = new FileInputStream("dbcp.txt");


        //InputStreamReader isr = new InputStreamReader(fis);//使用系统默认的字符集
        //参数2指明了字符集，具体使用那个字符集，取决于文件dbcp.txt保存时使用的字符集
        
        //转换流
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");


        char[] cubf = new char[20];
        int len;
        while ((len = isr.read(cubf)) != -1){
            String str = new String(cubf,0,len);
            System.out.print(str);
        }
        //关闭流资源
        isr.close();
    }



    /*
    综合使用InputStreamReader和OutputStreamWriter
     */
    @Test
    public void test2() throws IOException {

        //1.
        File file1 = new File("dbcp.txt");
        File file2 = new File("dbcp_gbk.txt");
        //2.基础流
        FileInputStream fis = new FileInputStream(file1);
        OutputStream fos = new FileOutputStream(file2);

        //2.处理流
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");

        //3.读写的过成


        char[] cubf = new char[20];
        int len;
        while ((len = isr.read(cubf)) != -1){
            osw.write(cubf,0,len);
        }


        //4.资源关闭
        osw.close();
        isr.close();

    }
}
