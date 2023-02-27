package com.lkw.spring6.service.impl;

import com.lkw.spring6.dao.UserDao;
import com.lkw.spring6.dao.impl.UserDaoImpl;
import com.lkw.spring6.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Override
    public void deleteUser() {
        // 调用持久层删除用户数据
        userDao.deleteById();
    }
}
