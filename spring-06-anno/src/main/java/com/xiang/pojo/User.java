package com.xiang.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //等价于<bean id="user" class="com.xiang.pojo.User"/> 表示这是一个组件
@Scope("prototype")
public class User {
    @Value("婵娟")
    public String name;
    //也可以在set方法注入，重复注入会覆盖。
    @Value("明月")
    public void setName(String name) {
        this.name = name;
    }
}
