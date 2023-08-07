package com.zhengxifeng.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;

/**
 * @author shkstart
 * @create 2022-01-21 20:22
 */
public class PropertiesTest {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();
            fis = new FileInputStream("jdbc.properties");
            pros.load(fis);//加载流对应的文件
            String name = pros.getProperty("name");
            String password = pros.getProperty("password");
            System.out.println("name = " + name + ",    password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                fis.close();
            }
        }
    }
}
