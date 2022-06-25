package com.xiang.demo02;

//真实对象
public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("增加了一位用户");
    }

    @Override
    public void delete() {
        System.out.println("删除了一位用户");
    }

    @Override
    public void update() {
        System.out.println("修改了一位用户");
    }

    @Override
    public void query() {
        System.out.println("查询了一位用户");
    }
    //新增功能去改源代码是开发中的大忌
}
