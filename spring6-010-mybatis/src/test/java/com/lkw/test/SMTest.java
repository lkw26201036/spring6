package com.lkw.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.lkw.bank.pojo.Account;
import com.lkw.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SMTest {


    @Test
    public void testSM(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);

    }



}
