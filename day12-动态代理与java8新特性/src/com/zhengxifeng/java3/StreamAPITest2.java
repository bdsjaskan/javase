package com.zhengxifeng.java3;

import com.zhengxifeng.java2.Employee;
import com.zhengxifeng.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream的终止操作
 * @author 郑喜峰
 * @create 2022-02-24 17:30
 */
public class StreamAPITest2 {
    ///1-匹配与查找
    @Test
    public void test1(){
//        allMatch(Predicate p)一检查是 否匹配所有元素。
//        练习:是否所有的员工的年龄都大于18

        List<Employee> list = EmployeeData.getEmployees();
        boolean allMatch = list.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);

//        anyMatch(Predicate p)-检查是 否至少匹配一个元素。
//        练习:是否存在员工的工资大于10000

        boolean anyMatch = list.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch );
//        noneMatch(Predicate p)一检查是否没有匹配的元素。
//        练习:是否存在员工姓“雷

        boolean noneMatch = list.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);


//        findFirst - 返回第一个元素
        Optional<Employee> employee = list.stream().findFirst();

        System.out.println(employee);


//        findAny-返回当前流 中的任意元素

        Optional<Employee> employee1 = list.parallelStream().findAny();
        System.out.println(employee1);



    }
    @Test
    public void test2(){
//        count-返回流中元素的总 个数

        List<Employee> employees = EmployeeData.getEmployees();
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();

        System.out.println(count);


//        max(Comparator c)-返回流中最大值
//        练习:返回最高的工资:
        Stream<Double> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> maxSalary = salaryStream.max(Double::compare);
        System.out.println(maxSalary);

//        min(Comparator c)一返回流中最小值
//        练习:返回最低工资的员I
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));

        System.out.println(min);


//        forEach(Consumer c)-内部迭代

        employees.stream().forEach(System.out::println);




        //使用集合的遍历操作
        employees.forEach(System.out::println);


    }


 //2-归纳
    @Test
    public void test3(){

        //reduce(T identity, BinaryOperator) -- 可以将流中的元素反复结合起来，得到一个值。返回T
        //练习：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        //reduce(BinaryOperator) -- 可以将流元素反复结合起来，得到一个值。返回Optional<T>
        //练习2：计算公司所有员工工资的总和


        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
        Optional<Double> reduce1 = salaryStream.reduce(Double::sum);
        System.out.println(reduce1);


    }

    //3-收集
    @Test
    public void test4(){
        //collect(Collector c) -- 将流转换为其他形式.接收一个Collector 接口的实现，用于给Stream中元素做汇总的方法
        //练习1：查找工资大于6000的员工，结果返回为一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out::println);

        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());

        employeeSet.forEach(System.out::println);
    }




}
