package com.lkw.test;

import com.lkw.bank.pojo.Account;
import com.lkw.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountTest {

    @Test
    public void testMyBatis(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        List<Account> list = accountService.getAll();
        System.out.println(list);
    }

    @Test
    public void testContext(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Account account = applicationContext.getBean("account", Account.class);
        System.out.println(account);
    }
}
