package com.etoak.controller;

import com.etoak.bean.Book;
import com.etoak.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value="/book")
public class BookController {
@Autowired
private BookService bookservice;

	@RequestMapping(value="/list",
			method=RequestMethod.GET)
	public String list() {
		return "book/list";
	}

	@ResponseBody
	@RequestMapping(value="/query",
			method=RequestMethod.POST)
	public Map<String,Object> query(
			Integer page,Integer rows,Book book) {

		return bookservice.query(page, rows, book);

	}
}
