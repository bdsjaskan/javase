package com.zhengxifeng.java1;

import org.junit.Test;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-01-24 19:11
 */
public class DAOTest {
    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();


        dao1.add(new Customer());

        List<Customer> list = dao1.getForList(10);

        StudentDAO dao2 = new StudentDAO();
        dao2.add(new Student());
        Student index = dao2.getIndex(1);



    }

}
