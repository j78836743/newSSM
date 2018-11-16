package com.etoak.mapper;

import com.etoak.bean.Bicycle;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BicycleMapper {

	/**
	 * 添加Bicycle信息
	 */
	public int add(Bicycle bicycle);
	
	/**
	 * 通过编号获取Bicycle信息
	 */
	public Bicycle getbicycleName(@Param("bicycleName") String  bicycleName,@Param("publish")String publish);
	
	/**
	 * Bicycle列表查询
	 */
	public List<Bicycle> query(Bicycle bicycle);
	
	/**
	 * 通过主键查询Bicycle信息
	 */
	public Bicycle findEmpByPrimaryKey(@Param("id") Integer id);
	
	/**
	 * 通过主键修改Bicycle信息
	 */
	public int update(Bicycle bicycle);
	
	/**
	 * 批量删除Bicycle信息
	 */
	public int remove(Integer id);


	public List<Bicycle> getbicyclecodeAndbicycleName();

	public Bicycle getnowcountBybicyclecode(String bicyclecode);



	public void send(Bicycle b);


	public  Bicycle getbicycleId(Integer bicycleId);
}
