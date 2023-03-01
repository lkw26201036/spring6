package com.lkw.test;

import com.lkw.spring.bean.*;
import com.lkw.spring.bean2.MyDataSource;
import com.lkw.spring.bean2.User;
import com.lkw.spring.config.SpringConfig;
import com.lkw.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {

    @Test
    public void testAnnotation(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
        Vip vipBean = applicationContext.getBean("vipBean", Vip.class);
        System.out.println(vipBean);
        Customer customerBean = applicationContext.getBean("customerBean", Customer.class);
        System.out.println(customerBean);
        Student studentBean = applicationContext.getBean("studentBean", Student.class);
        System.out.println(studentBean);
    }

    /**
     * 获取数据库连接池对象
     */
    @Test
    public void testDataSource(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("datasource.xml");
        MyDataSource dataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(dataSource);
        // 获取用户对象
        com.lkw.spring.bean2.User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);

    }


    @Test
    public void testNoXML(){
        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = config.getBean("userService", UserService.class);
        userService.delete();
    }




}
