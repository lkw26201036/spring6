package com.lkw.spring.service;

import com.lkw.spring.dao.UserDao;
import com.lkw.spring.dao.VipDao;

public class CustomerService {

    private UserDao userDao;
    private VipDao vipDao;

    public CustomerService(UserDao userDao, VipDao vipDao) {
        this.userDao = userDao;
        this.vipDao = vipDao;
    }

    public void testConstructor(){
        userDao.insert();
        vipDao.insert();
    }
}
