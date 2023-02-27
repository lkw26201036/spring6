package com.lkw.spring6.web;

import com.lkw.spring6.service.UserService;
import com.lkw.spring6.service.impl.UserServiceImpl;

/**
 * 表示层
 */
public class UserAction {
    private UserService userService = new UserServiceImpl();

    /**
     * 删除用户信息
     */
    public void deleteRequest(){
        userService.deleteUser();
    }
}
