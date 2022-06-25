package com.xiang.dao;

public class UserDaoMysqlImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.printf("Mysql获取用户数据!");
    }
}
