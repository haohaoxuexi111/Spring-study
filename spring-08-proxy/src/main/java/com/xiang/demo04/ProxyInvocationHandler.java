package com.xiang.demo04;

import com.xiang.demo03.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//代理实例的调用处理程序，等下我们会用这个类，自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {
    //被代理的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }
    //Proxy提供了创建动态代理类和实例的静态方法，它也是由这些方法创建的所有动态代理类的超类
    //得到代理类 (要代理的目标对象类加载器，与目标对象相同的接口字节码对象数组，ProxyInvocationHandler对象)
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }
    /*
    InvocationHandler（接口）是由代理实例的调用处理程序实现的接口
    每个代理实例都有一个关联的调用处理程序（真实角色），当在代理实例上调用方法时，
    方法（真实角色的方法）调用将被编码并分派到其 调用处理程序 的invoke方法。
     */
    @Override //处理代理实例，并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        //动态代理的本质，就是使用反射机制实现。
        Object result = method.invoke(target, args);//invoke--执行什么方法
        return result;
    }

    public void log(String msg){
        System.out.printf("执行" + msg + "方法");
    }

}
