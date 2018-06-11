package com.learning.mybatis.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.learning.mybatis.Application;
import org.learning.mybatis.bean.Dept;
import org.learning.mybatis.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DeptMapperTest {
	@Autowired
	private DeptMapper deptMapper;

	@Test
	public void testInsert() throws Exception {
		Dept bean = new Dept(70, "IT-APP", "SZ");
		deptMapper.insert(bean);
		
		Dept dept = deptMapper.selectByPrimaryKey(70);

		Assert.assertNotNull(dept);
		Assert.assertTrue(bean.getDeptName().equals(dept.getDeptName()));
	}
}
