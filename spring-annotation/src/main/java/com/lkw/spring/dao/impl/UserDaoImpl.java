package com.lkw.spring.dao.impl;

import com.lkw.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void delete() {
        System.out.println("mysql正在删除用户信息");
    }
}
