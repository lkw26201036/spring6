package com.lkw.spring6.bean;

public class GunFactory {
    // 工厂模式中的方法都是实例方法
    public Gun get(){
        return new Gun();
    }
}
