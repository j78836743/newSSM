package com.etoak.service;



import com.etoak.bean.Book;

import java.util.Map;


public interface BookService {
	public void doAdd(Book book);
	 
	public Book getbookId(String bookId);

    public Map<String,Object> query(Integer page, Integer rows, Book book);

    public void update(Book book);
}
