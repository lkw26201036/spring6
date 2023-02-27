package com.lkw.spring6.test;

import com.lkw.spring.bean.User;
import com.lkw.spring.jdbc.MyDataSource;
import com.lkw.spring.service.CustomerService;
import com.lkw.spring.service.OrderService;
import com.lkw.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {


    private UserService userService;

    /**
     * 使用set方法进行注入
     */
    @Test
    public void testDI(){
        // 创建上下文对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        // 通过容器创建对象
        UserService userService = applicationContext.getBean("userService", UserService.class);
        // 调用userService的相关方法
        userService.saveUser();
    }


    /**
     * 通过构造方法进行注入
     */
    @Test
    public void testConstructor(){
        // 创建上下文对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        // 通过容器创建对象
        CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);
        // 调用userService的相关方法
        customerService.testConstructor();
    }


    /**
     * 给简单类型字段赋值
     */
    @Test
    public void testSimple(){
        // 创建上下文对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("user.xml");
        // 通过容器创建对象
        User user = applicationContext.getBean("user", User.class);
        // 输出User对象
        System.out.println(user);
    }

    /**
     * 测试根据名称进行自动装配
     */

    @Test
    public void testAutowire(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.insert();
    }


    /**
     * 测试从外部读取配置文件
     */

    @Test
    public void testProperties(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-properties.xml");
        MyDataSource datasource = applicationContext.getBean("datasource", MyDataSource.class);
        System.out.println(datasource);
    }
}
