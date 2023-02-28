package com.lkw.spring.test;

import com.lkw.myspring.bean.UserService;
import org.junit.Test;
import org.lkw.core.ApplicationContext;
import org.lkw.core.ClassPathXmlApplicationContext;

public class MySpringTest {

    @Test
    public void testMySpring(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring.xml");
        // 测试bean是否注入成功
        Object user = applicationContext.getBean("user");
        System.out.println(user);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
    }
}
