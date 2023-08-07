package com.zhengxifeng.java;

import org.junit.Test;

import java.io.*;

/**
 *
 * 处理流之一：缓冲流的使用
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 *
 * 2.作用：提供流的读取、写入的速度
 *   提高读写速度的原因：内部提供了一个缓冲区
 *
 *
 *   3.处理流，就是“套接”在已有的流的基础上。
 * @author shkstart
 * @create 2022-01-29 18:54
 */
public class BufferedTest {

    /*
    实现非文本文件的复制
     */
    @Test
    public void BufferedStreamTest() throws FileNotFoundException {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File("1月28号.jpg");
            File destFile = new File("1月28号33.jpg");
            //2.造流
            //2.1造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入

            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            //要求：先关闭外层的流，在关闭内层的流


            if (bos != null){

                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null){

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
//        fos.close();
//        fis.close();
        }

    }

    //实现文件复制的方法
    public void copyFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.造流
            //2.1造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
//                bos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            //要求：先关闭外层的流，在关闭内层的流


            if (bos != null){

                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null){

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
//        fos.close();
//        fis.close();
        }
    }

    @Test
    public void testCopyFileWithBuffered(){

        long start = System.currentTimeMillis();


//        String srcFile = "hello.txt";
//        String destFile = "hello5.txt";


        String srcFile = "C:\\Users\\郑喜峰\\Desktop\\01-视频.avi";
        String destFile = "C:\\Users\\郑喜峰\\Desktop\\03-视频.avi";

        copyFileWithBuffered(srcFile,destFile);


        long end = System.currentTimeMillis();


        System.out.println("复制所花费的时间 = " + (end - start));
    }



    @Test
    public void testbufferedReaderBufferedWriter(){

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //1.创建相应文件和流资源
            br = new BufferedReader(new FileReader(new File("hello4.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello6.txt")));

            //2.读写操作
            //方式1：使用char[] 数组
//            char[] cubf = new char[1024];
//            int len;
//            while ((len = br.read(cubf)) != -1){
//                bw.write(cubf,0,len);
//            }

            //方式2：使用String
            String data;
            while ((data = br.readLine()) != null){

                //方法1：
//                bw.write(data + "\n");//data中不包含换行符

                //方法2：
                bw.write(data);//data中不包含换行符
                bw.newLine();//提供换行的操作
            }



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭资源

            if (bw != null){

                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null){

                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }





    }


}