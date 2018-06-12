package com.learning.mybatis.mapper;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.learning.mybatis.Application;
import org.learning.mybatis.bean.Dept;
import org.learning.mybatis.bean.Emp;
import org.learning.mybatis.mapper.DeptMapper;
import org.learning.mybatis.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class EmpMapperTest {
	@Autowired
	private DeptMapper deptMapper;
	
	@Autowired
	private EmpMapper empMapper;

	@Test
	public void testInsert() throws Exception {
		Integer deptNo = 96;
		
		Dept bean = new Dept(deptNo, "IT-APP", "SZ");
		deptMapper.insert(bean);
		Dept dept = deptMapper.selectByPrimaryKey(deptNo);
		Assert.assertNotNull(dept);
		Assert.assertTrue(bean.getDeptName().equals(dept.getDeptName()));
		
		Integer employeeNo = 2;
		Emp emp = new Emp();
		emp.setEmployeeNO(employeeNo);
		emp.setEmployeeName("summer");
		emp.setJob("Engineer");
		emp.setMgr(3000);
		emp.setHireDate(new Date());
		emp.setSalary(new BigDecimal(10000));
		emp.setComm(new BigDecimal(2000));
		emp.setDept(bean);
		empMapper.insert(emp);
		
		Emp empDB = empMapper.selectByPrimaryKey(employeeNo);
		Assert.assertNotNull(empDB);
		Assert.assertTrue(empDB.getEmployeeNO() == emp.getEmployeeNO());
	}
}
