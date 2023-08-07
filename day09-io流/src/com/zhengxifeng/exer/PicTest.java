package com.zhengxifeng.exer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2022-01-29 22:06
 */
public class PicTest {

    //图片的加密
    @Test
    public void test1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            fis = new FileInputStream("1月28号.jpg");
            fos = new FileOutputStream("1月28号secret.jpg");
            //
            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1){

                //对字节数据进行修改

    //            //错误的
    //            for (byte b : buffer){
    //                b = (byte) (b ^ 5);
    //            }

                //正确的
                for (int i = 0; i < len; i++){
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }


                fos.write(buffer,0 ,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.

            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (fis != null){

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    //图片的解密
    @Test
    public void test2(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            fis = new FileInputStream("1月28号secret.jpg");
            fos = new FileOutputStream("1月28号44.jpg");
            //
            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1){

                //对字节数据进行修改

                //            //错误的
                //            for (byte b : buffer){
                //                b = (byte) (b ^ 5);
                //            }

                //正确的
                for (int i = 0; i < len; i++){
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }


                fos.write(buffer,0 ,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.

            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (fis != null){

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

}
