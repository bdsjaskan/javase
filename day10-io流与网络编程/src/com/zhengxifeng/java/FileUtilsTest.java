package com.zhengxifeng.java;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2022-02-06 22:21
 */
public class FileUtilsTest {
    public static void main(String[] args) {
        File srcfile = new File("day10-io流与网络编程\\爱情与友情.jpg");
        File destfile = new File("day10-io流与网络编程\\爱情与友情2.jpg");

        try {
            FileUtils.copyFile(srcfile,destfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
