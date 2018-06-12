package org.learning.mybatis.service;

import org.learning.mybatis.bean.Dept;
import org.learning.mybatis.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptService {
	@Autowired
	private DeptMapper deptMapper;

	@Transactional
	public void addDept(Dept dept) {
		deptMapper.insert(dept);
	}

	public Dept findByDeptNO(Integer deptNo) {
		return deptMapper.selectByPrimaryKey(deptNo);
	}
}