package com.lkw.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 *  切面 = 通知 + 切点
 */
@Component
@Aspect // 切面类需要使用这个注解来标注
public class LogAspect { // 切面
    // 通知就是增强，就是具体要实现的增强代码
    // 这里的Advice以方法的形式出现
    @Before("execution(* com.lkw.service.UserService.*(..))") // 标注的方法就是前置通知，里面写切点表达式
    public void enhance(){
        System.out.println("前置通知");
    }

    @AfterReturning("execution(* com.lkw.service..*(..))") // 后置通知
    public void afterReturning(){
        System.out.println("后置通知");
    }

    @Around("execution(* com.lkw.service..*(..))") // 环绕通知
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("前环绕通知");
        // 调用目标方法
        joinPoint.proceed();
        System.out.println("后环绕通知");
    }

}
