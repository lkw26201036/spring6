package com.lkw.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
// 标注注解的注解，叫做元注解  @Target注解可以用来修饰@Component注解可以出现的位置
@Target(value = {ElementType.TYPE, ElementType.FIELD}) // 说明这个注解可以出现类上，也可以出现在属性上
// 标注@Component最终保存在class文件中，并且可以被反射机制读取到，因为
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    // 定义注解的属性
    // String -- 属性类型
    // value -- 属性名
    String value();
}
















