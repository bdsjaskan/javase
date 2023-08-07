package com.zhengxifeng.java;

import org.junit.Test;

import java.io.*;
import java.lang.annotation.Target;

/**
 *
 * 一、流的分类
 *
 * 1.操作数据单位不同 分为 ：字节流，字符流
 * 2.数据的流向：输入流，输出流
 * 3.数据角色：节点流，处理流
 *
 * 二、流的体系结构
 * 抽象基类             节点流 （或文件流）                                  缓冲流（处理流的一种）
 * InputStream          FileInputStream   (read(byte[] buffer))            BufferedInputStream  (read(byte[] buffer))
 * OutputStream         FileOutputStream  (writer(byte[] buffer,0,len))    BufferedOutputStream (writer(byte[] buffer,0,len)  /  flush()  )
 * Reader               FileReader        (read(char[] cubf))              BufferedReader       (read(char[] cubf)  /   readLine())
 * Writer               FileWriter        (writer(char[] cubf,0,len))      BufferedWriter       (writer(char[] cubf,0,len) / flush() )
 * @author shkstart
 * @create 2022-01-26 12:37
 */
public class FileReaderWriterTest {

//    public static void main(String[] args) {
//        File file1 = new File("hello.txt");
//        System.out.println(file1.getAbsolutePath());
//
//        File file2 = new File("day09-io流\\hello.txt");
//        System.out.println(file2.getAbsolutePath());
//
//    }

    /*
    将day09下的hello.txt文件内容读入程序中，并输出到控制台


    说明点：
    1. read()的理解,返回读入的一个字符。如果达到文件末尾，返回-1.
    2. 异常的处理，为了保证流资源一定可以执行关闭操作。需使用 try-catch-finally处理
    3. 读入的文件一定要存在，否则就会报FileNotFoundException

     */

    @Test
    public void test1() {
        FileReader fr = null;
        try {
            //1.实例化File对象，指明需要操作的文件
            File file = new File("hello.txt");//

            //2.提供具体的流
            fr = new FileReader(file);

            //3.数据的读入过程
            //read():返回读入的一个字符。如果达到文件末尾，返回-1.
            //方式一：
//        int data = fr.read();
//
//        while(data != -1){
//            System.out.print((char) data);
//            data = fr.read();
//        }

            //方式二：
            int data;
            while ((data = fr.read()) != -1){
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
//            try {
//                if (fr != null)
//                    fr.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            //或
            if (fr != null){
                try {

                        fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }




    }


    //对read()操作升级：使用read的重载方法

    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            //1.  File类的实例化

            File file = new File("hello.txt");

            //2.  流的实例化（FileReader）

            fr = new FileReader(file);
            //3.  读入的具体操作
            //read(char[] cubf)方法：返回每次读入cubf数组中的字符的个数。如果达到文件末尾返回-1
            char[] cbuf = new char[5];
            int len;
//        fr.read(cbuf);
            while ((len = fr.read(cbuf)) != -1){
                //方式一-------------
                //错误写法：输出
    //            for (int i = 0; i < cubf.length; i++) {
    //                System.out.println(cbuf[i]);
    //
    //            }
                //正确的
//                for (int i = 0; i < len; i++) {
//                    System.out.println(cbuf[i]);
//
//                }
                //方式二--------------------------
                //错误的写法
//                String str = new String(cbuf);
//                System.out.println(str);

                //正确的写法
                String str = new String(cbuf,0,len);
                System.out.print(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null){
                //4.  资源的关闭
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }






    }

    /*

    从内存中写出数据到硬盘的文件里。

    说明：
    1. 输出操作，对应的File可以不存在的。并不会报异常
    2.
        File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
        File对应的硬盘中的文件如果存在:
                如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件的覆盖
                如果流使用的构造器是：FileWriter(file,true):不会对原有文件覆盖，而是在原有文件基础上追加内容
     */
    @Test
    public void testFileWriter() {
        FileWriter fw = null;
        try {
            //1.提供File类的对象  ，指明写出到的文件
            File file = new File("hello1.txt");
            //2.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file,true);
            //3.具体的写出操作
            fw.write("I have a dream!\n");
            fw.write("you need to have a dream!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4.流资源的关闭
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }


    }



    @Test
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");

//            //不能使用字符流来处理图片等字节数据
//            File srcFile = new File("1月28号.jpg");
//            File destFile = new File("1月28号1.jpg");

            //2.创建输入流和输出流的对象

            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);


            //3.数据的读入和写出操作

            char[] cbuf = new char[5];
            int len;//记录每次读入到cbuf数组中的字符的个数
            while ((len = fr.read(cbuf)) != -1){
                //每次写出len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4.关闭流资源


            //方式一：
//            try {
//                if (fw != null){
//                    fw.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }finally{
//
//              try {
////                if (fr != null){
////                    fr.close();
////                }
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
//            }
//

            //方式二：
            try {
                if (fw != null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fr != null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        
    }

    @Test
    public void testFileInputStreamFileOutputStream() {
        FileInputStream fm = null;
        FileOutputStream fs = null;

        try {
            //1.
            File file1 = new File("1月28号.jpg");
            File file2 = new File("1月28号00.jpg");

            //2.
            fm = new FileInputStream(file1);
            fs = new FileOutputStream(file2);

            //3.
            byte[] bytes = new byte[5];
            int len;
            while ((len = fm.read(bytes)) != -1){

                fs.write(bytes,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4.
            try {
                if (fm != null){
                    fm.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fs != null){
                    fs.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }



}
