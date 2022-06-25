package com.xiang.service;

public class UserServiceImpl implements UserService{
    @Override
    public int add() {
        System.out.println("增加了一个用户");
        return 11;
    }

    @Override
    public void delete() {
        System.out.println("删除了一个用户！");
    }

    @Override
    public void update() {
        System.out.println("修改了一个用户！");
    }

    @Override
    public void select() {
        System.out.println("查询了一个用户！");
    }
}
