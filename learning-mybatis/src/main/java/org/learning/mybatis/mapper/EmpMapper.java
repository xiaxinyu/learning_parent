package org.learning.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.learning.mybatis.bean.Emp;

@Mapper
public interface EmpMapper {
	int deleteByPrimaryKey(Integer employeeNO);

	int insert(Emp emp);

	Emp selectByPrimaryKey(Integer employeeNO);
}