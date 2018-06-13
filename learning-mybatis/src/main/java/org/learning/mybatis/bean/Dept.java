package org.learning.mybatis.bean;

import java.io.Serializable;

public class Dept implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer deptNo;

	private String deptName;

	private String location;

	public Dept() {
	}

	public Dept(Integer deptNo, String deptName, String location) {
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.location = location;
	}

	public Integer getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}