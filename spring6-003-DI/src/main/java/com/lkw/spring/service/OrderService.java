package com.lkw.spring.service;

import com.lkw.spring.dao.OrderDao;

public class OrderService {
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }


    public void insert(){
        orderDao.insert();
    }
}
