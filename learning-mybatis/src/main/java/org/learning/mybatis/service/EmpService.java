package org.learning.mybatis.service;

import org.learning.mybatis.bean.Emp;
import org.learning.mybatis.mapper.DeptMapper;
import org.learning.mybatis.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpService {
	@Autowired
	private DeptMapper deptMapper;

	@Autowired
	private EmpMapper empMapper;

	@Transactional
	public void addEmp(Emp emp) {
		deptMapper.insert(emp.getDept());
		empMapper.insert(emp);
	}
	
	public Emp findEmp(Integer employeeNO) {
		return empMapper.selectByPrimaryKey(employeeNO);
	}
}
