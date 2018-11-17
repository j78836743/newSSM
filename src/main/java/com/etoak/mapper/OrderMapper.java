package com.etoak.mapper;

import com.etoak.bean.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

	/**
	 * 添加Bicycle信息
	 */
	public int add(Order order);


	/**
	 * Bicycle列表查询
	 */
	public List<Order> query(Order order);


	public Integer getMaxid();

	public  Order getOrder(Integer id);

	public void update(Order o);

	public int acount();

	public int acount1();

	public int acounta();
	public int acountb();
	public int acountc();
	public int acountd();

}
