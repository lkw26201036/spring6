package com.lkw.spring6.test;

import org.junit.Test;

import java.lang.reflect.Method;

public class TestReflect {

    @Test
    public void testReflect() throws Exception {
        /**
         * 现在已知如下信息：
         *  1.有一个类，类名叫做：com.lkw.spring6.bean.User
         *  2.这个类符合javabean规范，属性私有化，对外提供get，set方法
         *  3.age属性的类型是int类型
         *  使用反射机制调用set方法，给User对象的age属性赋值
         */
        String className = "com.lkw.spring6.bean.User";
        String propertyName = "age";

        // 通过反射机制获取类
        Class<?> clazz = Class.forName(className);
        // 获取方法名
        String methodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
        Method method = clazz.getDeclaredMethod(methodName, int.class);

        // 准备对象 -- 调用无参构造方法创建对象
        Object obj = clazz.newInstance();
        // 调用方法
        method.invoke(obj, 21);
        System.out.println(obj);

    }
}
