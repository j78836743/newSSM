package com.etoak.controller;

import com.etoak.service.TypeService;
import com.etoak.util.MyNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/type")
public class TypeController {
	
	@Autowired
	private TypeService typeService;
	
	@ResponseBody
	@RequestMapping(value="/getType",method=RequestMethod.POST)
	public List<MyNode> getType(){
		
		return typeService.findDeptByPid();
		
	}
	
	
}
