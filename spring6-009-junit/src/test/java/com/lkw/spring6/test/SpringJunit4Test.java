package com.lkw.spring6.test;

import com.lkw.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SpringJunit4Test {

    // 注入User
    @Autowired
    private User user;

    @Test
    public void testJunit4(){
        System.out.println(user);
    }
}
