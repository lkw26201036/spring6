package com.lkw.spring6.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpringTest {
    @Test
    public void testFirstSpringTest(){
        // 第一步：获取spring容器对象
        // ApplicationContext 翻译为应用上下文，其实就是Spring容器，是一个接口，接口下面有很多实现类
        // ClassPathXmlApplicationContext 专门从类路径中加载spring配置文件的一个上下文对象
        // 这段代码只要执行，就相当于启动了Spring容器，解析spring的配置文件，实例化所有的对象，放到spring容器中
        // 注意：在这里也可以指定多个xml配置文件，文件之间使用逗号隔开
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");// 参数传递spring配置文件的路劲
        // 第二步：根据bean的id从容器中获取这个对象
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);

        // 如果bean的id不存在，会报错，不会返回null
        // 因为直接调用getBean方法返回的是Object类型的数据，因此需要强制类型转换
        // 如果不想使用强制类型转换的话，可以使用getBean方法传入第二个参数，执行目标对象的类型



    }

    @Test
    public void testLog(){
        // 使用日志记录器记录日志
        // 1，创建日志记录器对象
        Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);
        // 2.记录日志，根据不同级别记录日志
        logger.info("我是一条信息");
        logger.debug("我是一条调试信息");
        logger.error("我是一条错误信息");
    }
}
