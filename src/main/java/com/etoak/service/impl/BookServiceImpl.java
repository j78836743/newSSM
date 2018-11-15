package com.etoak.service.impl;

import com.etoak.bean.Book;
import com.etoak.mapper.BookMapper;
import com.etoak.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

	
	@Autowired
	private BookMapper bookmapper;
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void doAdd(Book book) {
		Book b = bookmapper.getbookId(book.getBookId());

		if(b!=null){
			throw new RuntimeException( "书籍编号"+ book.getBookId() +"已存在");
		}

	}

	@Override
	public Book getbookId(String bookId) {
		return null;
	}

	@Override
	public Map<String, Object> query(Integer page, Integer rows, Book book) {
		PageHelper.startPage(page,rows);
		List<Book> list =bookmapper.query(book);
		PageInfo<Book> p = new PageInfo<>(list);

		Map<String,Object> result = new HashMap<>();
		result.put("rows",list);
		result.put("total",p.getTotal());

		return result;
	}

	@Override
	public void update(Book book) {

	}



}
