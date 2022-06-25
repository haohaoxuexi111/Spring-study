package com.xiang.service;

import com.xiang.dao.UserDao;
import com.xiang.dao.UserDaoImpl;
import com.xiang.dao.UserDaoMysqlImpl;

public class UserServiceImpl implements UserService{

//    private UserDao userDao = new UserDaoImpl();
//    private  UserDao userDao = new UserDaoMysqlImpl();
    private UserDao userDao;

    //利用set动态实现值的注入
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
    @Override
    public void getUser() {
        userDao.getUser();
    }
}
