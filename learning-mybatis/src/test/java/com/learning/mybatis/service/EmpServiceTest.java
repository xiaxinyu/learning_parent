package com.learning.mybatis.service;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.learning.mybatis.Application;
import org.learning.mybatis.bean.Dept;
import org.learning.mybatis.bean.Emp;
import org.learning.mybatis.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class EmpServiceTest {
	@Autowired
	private EmpService empService;

	@Test
	public void testInsert() throws Exception {
		Integer deptNo = 82;
		Dept bean = new Dept(deptNo, "IT-APP", "SHENZHEN");
		
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
		empService.addEmp(emp);
		
		Emp empDB = empService.findEmp(employeeNo);
		Assert.assertNotNull(empDB);
		Assert.assertTrue(empDB.getEmployeeNO() == emp.getEmployeeNO());
	}
}
