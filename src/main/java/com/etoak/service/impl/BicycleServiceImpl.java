package com.etoak.service.impl;

import com.etoak.bean.Bicycle;
import com.etoak.mapper.BicycleMapper;
import com.etoak.service.BicycleService;
import com.etoak.util.OrderNode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BicycleServiceImpl implements BicycleService {

	
	@Autowired
	private BicycleMapper bicyclemapper;
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void doAdd(Bicycle bicycle) {

		Bicycle b = bicyclemapper.getbicycleName(bicycle.getBicycleName(),bicycle.getPublish());

		if(b!=null){
			throw new RuntimeException( "此类单车型"+ bicycle.getBicycleName() +"已存在");
		}
		int result = bicyclemapper.add(bicycle);
		if (result <= 0 ) {
			throw new RuntimeException("add" + bicycle.getBicyclecode() + "error");

		}

	}

	@Override
	public Bicycle getbicycleId(Integer bicycleId) {


	    return  bicyclemapper.getbicycleId(bicycleId);
	}


	@Override
	public Map<String, Object> query(Integer page, Integer rows, Bicycle bicycle) {
		PageHelper.startPage(page,rows);
		List<Bicycle> list =bicyclemapper.query(bicycle);
		PageInfo<Bicycle> p = new PageInfo<>(list);

		Map<String,Object> result = new HashMap<>();
		result.put("rows",list);
		result.put("total",p.getTotal());

		return result;
	}

	@Override
	public void update(Bicycle bicycle) {

		Bicycle b = bicyclemapper.getbicycleName(bicycle.getBicycleName(),bicycle.getPublish());

		if(b!=null){
			throw new RuntimeException( "此类单车型"+ bicycle.getBicycleName() +"已存在");
		}

		int result = bicyclemapper.update(bicycle);
		if(result <= 0) {
			throw new RuntimeException(
					"修改" + bicycle.getBicycleName() + "失败！");
		}


	}

	@Override
	public List<OrderNode> getbicyclecodeAndbicycleName() {
		List<OrderNode> list = new ArrayList<>();
		List<Bicycle> list2 = bicyclemapper.getbicyclecodeAndbicycleName();
		System.out.println(list2);

		for (Bicycle b : list2){
			System.out.println(b.getBicycleName()+"|"+b.getBicyclecode());
			OrderNode node =  new OrderNode();
			node.setId(b.getBicyclecode());
			node.setText(b.getBicycleName());
			System.out.println(node);
			list.add(node);
		}
		System.out.print("list"+list);
		return list;
	}

	@Override
	public boolean remove(Integer id) {

		int i = bicyclemapper.remove(id);
		System.out.println(id+",,"+i);
		return (i==1);
	}


}
