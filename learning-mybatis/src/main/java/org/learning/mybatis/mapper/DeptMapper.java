package org.learning.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.learning.mybatis.bean.Dept;

@Mapper
public interface DeptMapper {
	int deleteByPrimaryKey(Integer deptNo);

	int insert(Dept dept);

	Dept selectByPrimaryKey(Integer deptNo);
}