package org.learning.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.learning.mybatis.bean.Dept;

@Mapper
public interface DeptMapper {
	// int deleteByPrimaryKey(Short deptNo);

	@Insert("insert into dept (DEPTNO, DNAME, LOC) values (#{deptNo}, #{deptName}, #{location})")
	int insert(Dept dept);

	@Select("select * from dept d where d.deptno = #{deptNo}")
	@Results({ 
		@Result(property = "deptNo", column = "DEPTNO"),
		@Result(property = "deptName", column = "DNAME"),
		@Result(property = "location", column = "LOC")})
	Dept selectByPrimaryKey(Integer deptNo);

	// int updateByPrimaryKey(Dept record);
}