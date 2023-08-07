package com.zhengxifeng.java4;

import org.junit.Test;

import java.util.Optional;

/**
 *
 * Optional类：为了在程序中避免出现空指针异常而创建的
 *
 * 常用方法：ofNullable(T t)
 *          orELse(T t)
 * @author 郑喜峰
 * @create 2022-02-25 18:39
 */
public class OptionalTest {

    /*
    Optional.of(T t) : 创建一个 Optional实例，不可以填入空的对象T（T必须非空）
    Optional.empty() ：创建一个空的 Optional 实例
    Optional.ofNullable(T t) : t 可以为空
     */
    @Test
    public void test1(){

        Girl girl = new Girl();
//        girl = null;
        //of(T t): 要保t是非空的
        Optional<Girl> girl1 = Optional.of(girl);
        System.out.println(girl1);


    }


    @Test
    public void test2(){
        Girl girl = new Girl();
        girl = null;
        //ofNullable(T t): t 可以为null
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
        //orElse(T t1): 如果当前的Optional内部封装的t是非空的，则返回内部的t
        //如果内部的t是空的，则返回orElse()方法中的参数t1
        Girl girl1 = optionalGirl.orElse(new Girl("赵丽颖"));
        System.out.println(girl1);
    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName();

    }

    @Test
    public void test3(){
        Boy boy = new Boy();
        boy = null;//不置为空 内部Girl也是空  都会产生空指针异常
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    //优化以后的getGirlName()方法
    public String getGirlName1(Boy boy){
        if (boy != null){
            Girl girl = boy.getGirl();
            if (girl != null){
                return girl.getName();
            }
        }
        return null;

    }

    @Test
    public void test4(){

        Boy boy = new Boy();
        boy = null;//不置为空 内部Girl也是空  都会产生空指针异常
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }


    //使用 Optional类的getGirlName():
    public String getGirlName2(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        //此时的boy1一定非空
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("迪丽热巴")));

        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        //girl一定非空
        Girl girl1 = girlOptional.orElse(new Girl("古力娜扎"));

        System.out.println(girl1.getName());

        return girl1.getName();

    }

    @Test
    public void test5(){

        Boy boy = new Boy();
//        boy = null;
        boy = new Boy(new Girl("苍老师"));
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
    }



}
