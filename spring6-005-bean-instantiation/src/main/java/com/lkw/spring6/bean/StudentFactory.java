package com.lkw.spring6.bean;

import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentFactory implements FactoryBean<Date> {
    private String strDate;

    public StudentFactory(String strDate) {
        this.strDate = strDate;
    }

    @Override
    public Date getObject() throws Exception {
        // 将日期进行格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 将传入的字符串日期解析成对象格式的Date类型的对象
        Date date = sdf.parse(strDate);
        return date;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
