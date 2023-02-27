package com.lkw.spring.test;

import com.lkw.spring.bean.SpringBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringScopeTest {

    @Test
    public void testSpringScope(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean springBean1 = applicationContext.getBean("springBean", SpringBean.class);
        System.out.println(springBean1);
        SpringBean springBean2 = applicationContext.getBean("springBean", SpringBean.class);
        System.out.println(springBean2);


        // 启动一个新的线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 创建两个对象
                SpringBean springBean3 = applicationContext.getBean("springBean",SpringBean.class);
                System.out.println(springBean3);
                SpringBean springBean4 = applicationContext.getBean("springBean",SpringBean.class);
                System.out.println(springBean4);
            }
        }).start();
    }
}
