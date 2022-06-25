package com.xiang.dao;

public class UserDaoOracleImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.printf("Oralce获取用户数据！");
    }
}
