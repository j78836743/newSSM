package com.etoak.service;


import com.etoak.bean.Bicycle;
import com.etoak.util.OrderNode;

import java.util.List;
import java.util.Map;


public interface BicycleService {
	public void doAdd(Bicycle bicycle);
	 
	public Bicycle getbicycleId(Integer bicycleId);

    public Map<String,Object> query(Integer page, Integer rows, Bicycle bicycle);

    public void update(Bicycle bicycle);


    public List<OrderNode> getbicyclecodeAndbicycleName();

    public boolean remove(Integer id);
}
