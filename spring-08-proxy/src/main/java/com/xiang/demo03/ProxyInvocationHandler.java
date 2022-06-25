package com.xiang.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//等下我们会用这个类，自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {
    //被代理的接口
    private Rent rent;
    public void setRent(Rent rent){
        this.rent = rent;
    }

    //得到代理类 (本类加载，代理接口类加载，ProxyInvocationHandler对象)
    public Object getProxy(){
//        JDK动态代理
        /*在创建的代理方法getProxy()中，使用了Proxy类的newProxyInstance()方法来创建代理对象。newProxyInstance()方法中包含3个参数，
        其中第1个参数是当前类的类加载器，第2个参数表示的是被代理对象实现的所有接口，第3个参数this代表的就是代理类JdkProxy本身。
        原文链接：https://blog.csdn.net/lcachang/article/details/86595470*/
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(),this);
    }

    @Override //处理代理实例的方法调用，并返回结果,当在代理实例上调用方法时，方法调用将被编码并分派到其调用处理程序(InvocationHandler)的invoke方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //动态代理的本质，就是使用反射机制实现。
        seeHouse();
        Object result = method.invoke(rent, args);//invoke--执行什么方法，参数（要代理的对象，方法参数）
        fare();
        return result;
    }

    public void seeHouse(){
        System.out.println("中介带客户看房子");
    }

    public void fare(){
        System.out.println("中介收取费用");
    }
}
