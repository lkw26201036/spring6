package com.lkw.spring6.bean;

/**
 * 这是一个bean，如何让spring帮我们创建对象呢
 * 实际上，spring是通过反射机制，调用这个类的无参数构造方法实现对象的创建的
 */
public class User {
    public User() {
        System.out.println("user的无参数构造方法执行");
    }
}
