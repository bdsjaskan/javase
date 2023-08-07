package com.zhengxifeng.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题3：
 * @author shkstart
 * @create 2022-02-08 21:36
 */
public class TCPTest3 {
      /*
    涉及到的异常需要用 try-catch-finally处理
     */

    @Test
    public void client() throws IOException {

        //1.
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
        //2.
        OutputStream os = socket.getOutputStream();

        //3.
        FileInputStream fis = new FileInputStream(new File("beauty.jpg"));

        //4.
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }

        //关闭数据的输出
        socket.shutdownOutput();

        //5.接受来自于服务器端的数据，并显示到控制台上
        InputStream ist = socket.getInputStream();
        ByteArrayOutputStream bais = new ByteArrayOutputStream();
        byte[] buffer1 = new byte[1024];
        int len1;
        while ((len1 = ist.read(buffer1)) != -1){
            bais.write(buffer1,0,len1);
        }
        System.out.println(bais.toString() );


        //6.
        fis.close();
        os.close();
        socket.close();
        bais.close();

    }
    /*
        涉及到的异常需要用 try-catch-finally处理
         */
    @Test
    public void server() throws IOException {
        //1.
        ServerSocket ss = new ServerSocket(9090);

        //2.
        Socket socket = ss.accept();

        //3.
        InputStream is = socket.getInputStream();


        //4
        FileOutputStream fos = new FileOutputStream(new File("beauty4.jpg"));

        //5.读写过程
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }

        System.out.println("图片传输完成");
        //6.
        OutputStream os = socket.getOutputStream();
        os.write("你好，我已收到文件".getBytes());


        //7.
        fos.close();
        is.close();
        socket.close();
        ss.close();
        os.close();

    }
}
