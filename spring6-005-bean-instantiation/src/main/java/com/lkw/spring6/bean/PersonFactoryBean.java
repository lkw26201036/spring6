package com.lkw.spring6.bean;

import org.springframework.beans.factory.FactoryBean;
// FactoryBean也是bean，只不过是一种特殊的bean
public class PersonFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        // 最终这个Bean的创建还是程序员自己new的
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    /**
     * 这个方法有默认的返回值为true，表示是单例的
     * 如果想要返回多例，直接返回false即可
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
