package com.etoak.controller;

import com.etoak.bean.Order;
import com.etoak.service.OrderService;
import com.etoak.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Map;

@Controller
@RequestMapping(value="/order")
public class OrderController {
	@Autowired
	private OrderService orderservice;


	@RequestMapping(value = "/list",
			method = RequestMethod.GET)
	public String list() {
		return "order/list";
	}

	@ResponseBody
	@RequestMapping(value = "/query")
	public Map<String, Object> query(
			Integer page, Integer rows, Order order) {
		return orderservice.query(page, rows, order);

	}

	@ResponseBody
	@RequestMapping(value = "/add")
	public ResultMsg add(Order order) {

		String str = "BICYCLE";
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);//获取年份
		str += year;

		int num = orderservice.getMaxid();
		int num2 = 10000 + num;

		String i = ("" + num2);
		str += i.substring(i.length() - 5);
		System.out.print(str);
		order.setOrderId(str);
		try {
			orderservice.doAdd(order);

			return new ResultMsg(200, "借success");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(500, "借出err");
		}
	}

	@ResponseBody
	@RequestMapping(value="/acount")
	public ResultMsg acount(){
		int i = 	orderservice.acount();
		int x= orderservice.acount1();
		return new ResultMsg(200, "今天"+i+"车借出"+",归还"+x);

	}

	@ResponseBody
	@RequestMapping(value = "/ret")
	public ResultMsg ret(HttpServletRequest request,
						 HttpServletResponse response) throws Exception {

		response.setCharacterEncoding("UTF-8");

		Integer id = Integer.valueOf(request.getParameter("id"));
		System.out.print(id);

		if (orderservice.ret(id)) {
			return new ResultMsg(200, "ok");
		}else {
			return new ResultMsg(500, "别改了");
		}
	}
}