package com.lkw.client;

import com.lkw.annotation.Component;

public class TestAnnotation {
    public static void main(String[] args) throws Exception {
        // 通过反射获取类上的注解
        // 读取类
        Class<?> aClass = Class.forName("com.lkw.bean.User");
        // 判断该类上有没有注解
        if (aClass.isAnnotationPresent(Component.class)) {
            // 获取类上的注解
            Component annotation = aClass.getAnnotation(Component.class);
            // 访问注解中的属性
            System.out.println(annotation.value());
        }
    }
}
