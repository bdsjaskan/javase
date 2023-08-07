package com.zhengxifeng.java;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 *
 * RandomAccessFile的使用
 *
 * 1.RandomAccessFile 直接继承于java.long.Object类，实现了DataInput和DataOutput接口
 * 2.RandomAccessFile 既可以作为一个输入流，又可以作为一个输出流
 * .3.如果RandomAccessFile 作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建，
 *    如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况， 从头覆盖）
 *
 * 4.可以通过相关的操作，实现RandomAccessFile“插入”数据的效果
 *
 *
 * @author shkstart
 * @create 2022-02-06 20:40
 */
public class RandomAccessFileTest {

    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            //1.
            raf1 = new RandomAccessFile(new File("1月28号.jpg"),"r");
            raf2 = new RandomAccessFile(new File("1月28号1.jpg"),"rw");

            //2.
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1){
                raf2.write(buffer,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf2 != null){

                //3.
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf1 != null){

                //3.
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

    }

    @Test
    public void test2() throws IOException {
        //1.
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");
        //2.
        raf1.seek(3);//将指针调到角标为3的位置


        raf1.write("xyz".getBytes());//覆盖效果

        //3.
        raf1.close();
    }



    /*
    使用 RandomAccessFile 实现数据的插入效果
     */
    @Test
    public void test3() throws IOException {
        //1.
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");
        //2.
        raf1.seek(3);//将指针调到角标为3的位置

        //保存指针3后面的所有数据到 StringBuilder中
        StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());

        byte[] buffer = new byte[20];
        int len;
        while ((len = raf1.read(buffer)) != -1){//数据已经存到数组buffer中
            builder.append(new String(buffer,0,len));



        }

        //调回指针，写入"xyz"
        raf1.seek(3);
        raf1.write("xyz".getBytes());

        //将StringBuilder中的数据写入到文件中
        raf1.write(builder.toString().getBytes());

        raf1.close();

        //思考：将StringBuilder替换为ByteArrayOutputStream

    }



}
