package org.learning.mybatis.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Emp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer employeeNO;
	private String employeeName;
	private String job;
	private Integer mgr;
	private Date hireDate;
	private BigDecimal salary;
	private BigDecimal comm;
	private Dept dept;

	public Integer getEmployeeNO() {
		return employeeNO;
	}

	public void setEmployeeNO(Integer employeeNO) {
		this.employeeNO = employeeNO;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public BigDecimal getComm() {
		return comm;
	}

	public void setComm(BigDecimal comm) {
		this.comm = comm;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
}