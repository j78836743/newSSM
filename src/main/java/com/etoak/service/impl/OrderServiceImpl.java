package com.etoak.service.impl;

import com.etoak.bean.Bicycle;
import com.etoak.bean.Order;
import com.etoak.bean.U;
import com.etoak.mapper.BicycleMapper;
import com.etoak.mapper.OrderMapper;
import com.etoak.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	private OrderMapper orderemapper;

	@Autowired
	private BicycleMapper bicyclemapper;



	@Override
	public Map<String, Object> query(Integer page, Integer rows, Order order) {
		PageHelper.startPage(page,rows);
		List<Order> list =orderemapper.query(order);
		PageInfo<Order> p = new PageInfo<>(list);

		Map<String,Object> result = new HashMap<>();
		result.put("rows",list);
		result.put("total",p.getTotal());

		return result;
	}

	@Transactional(propagation= Propagation.REQUIRED)
	@Override
	public void doAdd(Order order) {
		Bicycle b = bicyclemapper.getnowcountBybicyclecode(order.getBicyclecode());
		if(b.getNowcount()==0){
			throw new RuntimeException( "单车"+ b.getBicycleName()+"已没了");
		}

		int result = orderemapper.add(order);
		if (result <= 0 ) {
			throw new RuntimeException("add" +b.getBicycleName() + "error");

		}
		Integer i = b.getNowcount() - 1;
		b.setNowcount(i);
		bicyclemapper.send(b);


	}

	@Override
	public Integer getMaxid() {
		return  orderemapper.getMaxid();
	}

	@Override
	public boolean ret(Integer id) {
	Order o =	orderemapper.getOrder(id);
		if (o.getTerTime() !=null){
			return false;

		}
		o.setTerTime(new Date());

		orderemapper.update(o);

		Bicycle b = bicyclemapper.getnowcountBybicyclecode(o.getBicyclecode());
		Integer i = b.getNowcount() + 1;
		b.setNowcount(i);
		bicyclemapper.send(b);
		return true;
	}

	@Override
	public int acount() {
		return orderemapper.acount();
	}

	@Override
	public int acount1() {
		return orderemapper.acount1();
	}

	@Override
	public int acounta() {
		return orderemapper.acounta();
	}

	@Override
	public int acountb() {
		return orderemapper.acountb();
	}

	@Override
	public int acountc() {
		return orderemapper.acountc();
	}

	@Override
	public int acountd() {
		return orderemapper.acountd();
	}

	@Override
	public Map<String, Object> querycount(Integer page, Integer rows, U u) {
		PageHelper.startPage(page,rows);
		List<U> list =null;
		U uu = new U();
		uu.setDate(new Date());
		uu.setA(orderemapper.acounta());
		uu.setB(orderemapper.acountb());
		uu.setC(orderemapper.acountc());
		uu.setD(orderemapper.acountd());

		PageInfo<U> p = new PageInfo<>(list);
		Map<String,Object> result = new HashMap<>();
		result.put("rows",list);
		result.put("total",p.getTotal());

		return result;

	}


}
