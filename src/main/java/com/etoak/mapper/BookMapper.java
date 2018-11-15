package com.etoak.mapper;

import com.etoak.bean.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {

	/**
	 * 添加Book信息
	 */
	public int add(Book book);
	
	/**
	 * 通过编号获取Book信息
	 */
	public Book getbookId(@Param("bookId") Integer bookId);
	
	/**
	 * Book列表查询
	 */
	public List<Book> query(Book book);
	
	/**
	 * 通过主键查询Book信息
	 */
	public Book findEmpByPrimaryKey(@Param("id") Integer id);
	
	/**
	 * 通过主键修改Book信息
	 */
	public int update(Book book);
	
	/**
	 * 批量删除Book信息
	 */
	public int remove(@Param("bookId") List<Integer> bookId);
	
	
	
	
}
