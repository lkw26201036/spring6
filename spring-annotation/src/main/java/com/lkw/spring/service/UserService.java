package com.lkw.spring.service;

import com.lkw.spring.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    @Autowired
    private UserDao userDao;

    public void delete(){
        userDao.delete();
    }

}
