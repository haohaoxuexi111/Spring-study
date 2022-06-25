package com.itcast.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyTest {
    public static void main(String[] args) {

        Target target = new Target();
        Advice advice = new Advice();

        // 返回值就是动态生成的代理对象 基于cglib
        // 1. 创建增强器
        Enhancer enhancer = new Enhancer();
        // 2. 设置父类（要代理的目标对象）
        enhancer.setSuperclass(Target.class);
        // 3. 设置回调函数
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                advice.before();
                Object invoke = method.invoke(target, args);
                advice.afterReturning();
                return null;
            }
        });
        // 生成代理对象
        Target proxy = (Target) enhancer.create();
        proxy.save();
    }
}
