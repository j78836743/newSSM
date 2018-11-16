package com.etoak.mapper;

import com.etoak.bean.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeMapper {
	
	public List<Type> findTypesBybookTypeId();
	
}
