package com.zhengxifeng.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * 动态代理的举例
 * @author shkstart
 * @create 2022-02-16 20:40
 */

interface Human{

    String getBelief();

    void eat(String food);



}
//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);

    }
}

/*
要想实现动态代理，需要解决的问题？
问题1：如何根据加载到内存中的被代理类，动态创建一个代理类及其对象。
问题2：当通过代理类的对象调用方法时，如何动态的去调用被代理类 中的同名方法。


 */

class ProxyFactory{//通过工厂的方法动态生产代理类

    //调用此方法，返回一个代理类的对象  解决问题1
    public static Object getProxyInstance(Object obj){//obj：被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

                                        //类的加载器      +      接口        +   接口（解决问题2）
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handler);

    }

}

//实现接口*（解决问题2）
class MyInvocationHandler implements InvocationHandler{

    private Object obj;//赋值时，需要使用被代理类的对象进行赋值


    public void bind(Object obj){
        this.obj = obj;
    }



    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    //将被代理类要执行的方法a的功能就声明在 invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method：即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj：被代理类的对象
        Object returnValue = method.invoke(obj, args);
        //上述方法返回值就作为当前类的invoke()的返回值。
        return returnValue;



    }
}


public class ProxyTest {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();

        //proxyInstance ： 代理类的  对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);

        //当通过代理类对象调用方法时   会自动的调用被代理类中同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("意大利面");


        System.out.println("********************************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);

        proxyClothFactory.produceCloth();

    }



}
