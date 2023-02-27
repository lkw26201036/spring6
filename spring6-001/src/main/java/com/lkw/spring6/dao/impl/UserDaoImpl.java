package com.lkw.spring6.dao.impl;

import com.lkw.spring6.dao.UserDao;

public class UserDaoImpl implements UserDao {


    @Override
    public void deleteById() {
        System.out.println("Mysql数据库正在删除用户信息");
    }
}
