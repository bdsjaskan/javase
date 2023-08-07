package com.zhengxifeng.java3;

import com.zhengxifeng.java2.Employee;
import com.zhengxifeng.java2.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 *
 * @author 郑喜峰
 * @create 2022-02-24 15:11
 */
public class StreamAPITest1 {

    //1.筛选与切片
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        //filter(Predicate p) ---  接受 Lambda  ，  从流中排除某些元素
        Stream<Employee> stream = employees.stream();

        //练习：查询员工  工资大于 7000的员工信息

        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        System.out.println(".......................");

        //limit(n) -- 截断流，使其元素不超过给定的数量。

        employees.stream().limit(3).forEach(System.out::println);


        System.out.println("......................");

        //skip(n) -- 跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流

        employees.stream().skip(3).forEach(System.out::println);


        System.out.println("...........................");


        //distinct() -- 筛选，通过流所生成元素的hashCode() 和 equals() 去除重复元素


        //先添加一些重复数据
        employees.add(new Employee(1010,"刘强东",40,8000));
        employees.add(new Employee(1010,"刘强东",40,8000));
        employees.add(new Employee(1010,"刘强东",40,8000));employees.add(new Employee(1010,"刘强东",40,8000));
        employees.add(new Employee(1010,"刘强东",40,8000));


//        System.out.println(employees);

        employees.stream().distinct().forEach(System.out::println);


    }
    //2 - 映射

    @Test
    public void test2(){
//        map(Function f) --接受一个函数作为参数，，将元素转换为其他形式或提取信息，该函数会被应用到到每一个元素上，并将其映射为一个新的元素.
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");

        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        //练习：获取员工名字长度大于3的员工姓名

        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> namesStream = employees.stream().map(employee -> employee.getName());//可以将Lambda表达式改为方法引用的方式 (Employee::getName)
        namesStream.filter(name -> name.length() > 3).forEach(System.out::println);


        //练习2：
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);

        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });


        System.out.println(".........................");

        //flatMap(Function f)


        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::fromStringToStream);
        characterStream.forEach(System.out::println);

    }
    //将字符串中的多个字符构成的集合转换为多应的Stream的实例
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()){
            list.add(c);
        }

        return list.stream();
    }

    @Test
    public void test3(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        List list1 = new ArrayList();
        list1.add(4);
        list1.add(5);
        list1.add(6);

        //集合中还有集合
        //list.add(list1);

        //集合中没有集合
        list.addAll(list1);

        //为了理解（flatMap就相当于addAll  会将Stream 打碎 ）
        System.out.println(list);

    }



    //3-排序
    @Test
    public void test4(){
        //sorted() - 自然排序
        List<Integer> list = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
        list.stream().sorted().forEach(System.out::println);

        //报错 原因： Employee没有实现Comparable接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);


        //sorted(Comparator com) - 定制排序

        List<Employee> employees = EmployeeData.getEmployees();

        employees.stream().sorted((e1,e2) -> {
            int ageValue = Integer.compare(e1.getAge(),e2.getAge());
            if (ageValue != 0){
                return ageValue;
            }else {
                return Double.compare(e1.getSalary(),e2.getSalary());//从小到大
            }
        }).forEach(System.out::println);


    }
}
