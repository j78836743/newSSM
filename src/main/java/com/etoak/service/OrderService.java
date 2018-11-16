package com.etoak.service;


import com.etoak.bean.Order;

import java.util.Map;


public interface OrderService {
    public Map<String,Object> query(Integer page, Integer rows, Order order);

    public void doAdd(Order order);

    public  Integer getMaxid();

    public  boolean ret(Integer id);

    public  int acount();

    public  int acount1();
}
