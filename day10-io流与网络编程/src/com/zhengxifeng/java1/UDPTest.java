package com.zhengxifeng.java1;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 *
 *
 * UDP协议的网络编程
 * @author shkstart
 * @create 2022-02-08 22:10
 */
public class UDPTest {
    //发送端
    @Test
    public void sander() throws IOException {

        DatagramSocket socket = new DatagramSocket();

        String str = "我是UDP方式发送的导弹";
        byte[] data = str.getBytes();

        InetAddress inet = InetAddress.getByName("127.0.0.1");

        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,9090);//数据报


        socket.send(packet);//发送数据

        socket.close();


    }

    //接收端
    @Test
    public void receiver() throws IOException {

        DatagramSocket socket = new DatagramSocket(9090);

        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf,0,buf.length);
        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();


    }
}
