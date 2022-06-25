package com.xiang.demo03;

public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host = new Host();
        //代理角色，现在还没生成
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        //通过调用程序处理角色来处理我们要调用的接口对象
        pih.setRent(host);
        //这里的proxy是动态生成的
        Rent proxy = (Rent) pih.getProxy();
        Object o = proxy.rent();
        System.out.println(o);
        System.out.println("=============");
        Object o2 = proxy.push();
        System.out.println(o2);
    }
}
