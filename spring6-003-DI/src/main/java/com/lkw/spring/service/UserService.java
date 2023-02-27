package com.lkw.spring.service;

import com.lkw.spring.dao.UserDao;

public class UserService {
    private UserDao userDao;

    // 使用set方式对属性值进行注入


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(){
        userDao.insert();
    }
}
