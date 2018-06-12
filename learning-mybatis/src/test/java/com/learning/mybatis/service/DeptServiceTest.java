package com.learning.mybatis.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.learning.mybatis.Application;
import org.learning.mybatis.bean.Dept;
import org.learning.mybatis.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DeptServiceTest {
	@Autowired
	private DeptService deptService;

	@Test
	public void testInsert() throws Exception {
		Integer deptNo = 71;
		Dept bean = new Dept(deptNo, "IT-APP", "Shenzhen");
		deptService.addDept(bean);

		Dept dept = deptService.findByDeptNO(deptNo);

		Assert.assertNotNull(dept);
		Assert.assertTrue(bean.getDeptName().equals(dept.getDeptName()));
	}
}
