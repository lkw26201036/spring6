package com.lkw.spring6.bean;

/**
 * Bean的生命周期粗略五步：
 * 第一步：实例化Bean（调用无参构造方法）
 * 第二步：给Bean属性进行赋值（调用set方法）
 * 第三步：初始化Bean（会调用Bean的init方法，这个方法需要自己写自己配）
 * 第四步：使用Bean
 * 第五步：销毁Bean（调用Bean的destroy方法，这个方法自己写自己配）
 */
public class Student {
    private String name;

    public void setName(String name) {
        System.out.println("第二步：给对象的属性赋值");
        this.name = name;
    }

    public Student() {
        System.out.println("第一步：调用无参构造方法实例化对象");
    }

    public void initBean(){
        System.out.println("第四步：init方法");
    }

    public void destroyBean(){
        System.out.println("第七步：destroy方法");
    }
}
