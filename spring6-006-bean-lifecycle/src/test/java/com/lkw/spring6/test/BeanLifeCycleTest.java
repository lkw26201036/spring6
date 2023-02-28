package com.lkw.spring6.test;

import com.lkw.spring6.bean.Student;
import com.lkw.spring6.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleTest {

    /**
     * spring只对singleton对bean进行完整的生命周期的管理
     * 如果是prototype作用域的bean，spring容器只负责将该bean初始化完毕，等程序客户端一旦获取到该bean之后，spring容器就不再管理该对象的生命周期了
     */

    @Test
    public void testLifeCycleFive(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println("第六步:使用Bean" + student);
        // 调用销毁方法销毁Bean
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();
    }

    @Test
    public void testRegisterBean(){
        // 手动new一个对象
        User user = new User();
        System.out.println(user);

        // 此时将以上这个创建的对象临时交给spring容器进行管理
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("user",user);
        // 从spring容器中获取该对象
        User userBean = factory.getBean("user", User.class);
        System.out.println(userBean);
    }
}
