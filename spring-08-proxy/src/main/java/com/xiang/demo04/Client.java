package com.xiang.demo04;

import com.xiang.demo02.UserService;
import com.xiang.demo02.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService = new UserServiceImpl();
        //代理角色，不存在
        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        pih.setTarget(userService);//设置需要代理的对象
        //生成动态代理类
        UserService proxy = (UserService) pih.getProxy();
        proxy.query();
        proxy.add();
        proxy.delete();
        proxy.update();

    }
}
