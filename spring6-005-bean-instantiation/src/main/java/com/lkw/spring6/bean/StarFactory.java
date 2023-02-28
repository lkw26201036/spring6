package com.lkw.spring6.bean;

public class StarFactory {
    // 提供一个静态方法用于创建Star
    public static Star get(){
        return new Star();
    }
}
