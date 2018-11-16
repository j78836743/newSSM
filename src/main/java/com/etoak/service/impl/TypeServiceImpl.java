package com.etoak.service.impl;

import com.etoak.bean.Type;
import com.etoak.mapper.TypeMapper;
import com.etoak.service.TypeService;
import com.etoak.util.MyNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeMapper typeMapper;


	@Override
	public List<MyNode> findDeptByPid() {

		List<MyNode> list = new ArrayList<>();


		List<Type> list2 = typeMapper.findTypesBybookTypeId();
		System.out.println("list2"+list2);

		for (Type t : list2){
			System.out.println(t.getBicycleTypeName()+"|"+t.getBicycleTypeId());
			MyNode node =  new MyNode();
			node.setId(t.getBicycleTypeId());
			node.setText(t.getBicycleTypeName());
			list.add(node);
		}
		System.out.print(list);
		return list;
	}
}