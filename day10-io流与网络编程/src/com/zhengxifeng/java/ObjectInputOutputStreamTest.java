package com.zhengxifeng.java;

import org.junit.Test;

import java.io.*;

/**
 *
 *
 * 对象流的使用
 * 1.ObjectInputStream 和 ObjectOutputStream
 * 2.作用：用于存储和读取 基本数据类型数据或对象的处理流。它的强大之处就是可以把java
 *
 *
 *
 * @author shkstart
 * @create 2022-02-06 19:05
 */
public class ObjectInputOutputStreamTest {

    /*
    1.序列化过程：将内存中的java对象保存到磁盘当中或通过网络传输出去

    使用 ObjectOutputStream  来实现

     */
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream oos = null;
        try {
            //1.
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));

            //2.
            oos.writeObject(new String("我爱北京天安门！"));
            oos.flush();//刷新操作

            oos.writeObject(new Person("我爱你",23));
            oos.flush();

            oos.writeObject(new Person("有钱",23,2,new Account(50000)));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null){

                //3.
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }


    }

    /*
    反序列化：将磁盘文件中的对象还原为内存中的一个java对象
    使用: ObjectInputStream 来实现
     */
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            //1.
            ois = new ObjectInputStream(new FileInputStream("Object.dat"));

            //2.
            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(str);

            Person p = (Person)ois.readObject();
            System.out.println(p);

            Person p1 = (Person)ois.readObject();
            System.out.println(p1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

            if (ois != null){

                //3.
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }




    }


}
