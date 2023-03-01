package com.lkw.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void login() {
        System.out.println("系统正在进行身份认证");
    }

    public void logout(){
        System.out.println("系统正在退出");
    }
}
