package com.xiang.demo02;

import org.junit.jupiter.api.Test;

public class UserServiceProxy implements UserService{
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }

    //在不改变UserServiceImple类的基础上，使用代理新增日志功能
    public void log(String msg){
        System.out.printf("使用" + msg + "方法");
    }

}
