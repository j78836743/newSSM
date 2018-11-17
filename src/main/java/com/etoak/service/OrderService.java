package com.etoak.service;


import com.etoak.bean.Order;
import com.etoak.bean.U;

import java.util.Map;


public interface OrderService {
    public Map<String,Object> query(Integer page, Integer rows, Order order);

    public void doAdd(Order order);

    public  Integer getMaxid();

    public  boolean ret(Integer id);

    public  int acount();

    public  int acount1();

    public int acounta();
    public int acountb();
    public int acountc();
    public int acountd();

    public  Map<String,Object> querycount(Integer page, Integer rows, U u);
}
