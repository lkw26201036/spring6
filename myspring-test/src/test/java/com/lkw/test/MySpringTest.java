package com.lkw.test;

import com.lkw.spring.bean.OrderService;
import org.junit.Test;
import org.lkw.core.ApplicationContext;
import org.lkw.core.ClassPathXmlApplicationContext;

public class MySpringTest {
    @Test
    public void testMySpring(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring.xml");
        Object vip = applicationContext.getBean("vip");
        System.out.println(vip);

        // 调用orderService的方法
        OrderService orderService = (OrderService) applicationContext.getBean("orderService");
        orderService.generate();
    }
}
