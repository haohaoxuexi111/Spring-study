package com.itcast.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {

        Target target = new Target();
        Advice advice = new Advice();

        // 返回值就是动态生成的代理对象
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override  // 调用代理对象的任何方法，实质执行的都是invoke方法
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                advice.before();
                Object result = method.invoke(target, args);  // 执行目标方法
                advice.afterReturning();
                return result;
            }
        });
        // 调用代理对象的方法
        proxy.save();
    }
}
