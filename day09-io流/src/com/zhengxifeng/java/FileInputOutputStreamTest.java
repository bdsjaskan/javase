package com.zhengxifeng.java;

import org.junit.Test;

import java.io.*;

/**
 *  测试FileInputStream 和 FileOutputStream的使用
 *
 *  结论：
 *  1.对于文本文件(.txt,.java,.c,.cpp),使用字符流处理
 *  2.对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,.........)，使用字节流处理
 *
 *
 * @author shkstart
 * @create 2022-01-28 22:31
 */
public class FileInputOutputStreamTest {
    //使用字节流处理文本文件，是可能出现乱码的
    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;
        try {
            //1.造文件
            File file = new File("hello.txt");

            //2.造流
            fis = new FileInputStream(file);

            //3.读数据
            byte[] buffer = new byte[5];

            int len;//记录每次读取的字节的个数

            while ((len = fis.read(buffer)) != -1){
                String str = new String(buffer,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            if (fis != null){

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }




    }


    /*
    实现对图片的复制操作

     */
    //处理
    @Test
    public void testFileInputStreamFileOutputStream() {
        FileInputStream fm = null;
        FileOutputStream fs = null;

        try {
            //1.
            File file1 = new File("1月28号.jpg");
            File file2 = new File("1月28号22.jpg");

            //2.
            fm = new FileInputStream(file1);
            fs = new FileOutputStream(file2);

            //3.
            byte[] bytes = new byte[5];
            int len;
            while ((len = fm.read(bytes)) != -1){

                fs.write(bytes,0,len);


            }
            System.out.println("复制成功！");
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


    public void copyFile(String srcPath,String destPath){

        FileInputStream fm = null;
        FileOutputStream fs = null;

        try {
            //1.
            File file1 = new File(srcPath);
            File file2 = new File(destPath);

            //2.
            fm = new FileInputStream(file1);
            fs = new FileOutputStream(file2);

            //3.
            byte[] bytes = new byte[1024];
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


    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();


//        String srcFile = "hello.txt";
//        String destFile = "hello5.txt";


        String srcFile = "C:\\Users\\郑喜峰\\Desktop\\01-视频.avi";
        String destFile = "C:\\Users\\郑喜峰\\Desktop\\02-视频.avi";

        copyFile(srcFile,destFile);

        long end = System.currentTimeMillis();


        System.out.println("复制所花费的时间 = " + (end - start));
    }
}
