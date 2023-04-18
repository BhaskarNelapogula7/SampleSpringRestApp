package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_tab")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private Integer empId;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "emp_email")
	private String empEmail;

	@Column(name = "emp_phnum")
	private String empPhNum;

	@Column(name = "emp_sal")
	private int empSal;

	@Column(name = "emp_gender")
	private String empGender;

	
	public Employee() {
		super();
	}
	public Employee(Integer empId) {
		super();
		this.empId = empId;
	}

	public Employee(Integer empId, String empName, String empEmail, String empPhNum, int empSal, String empGender) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPhNum = empPhNum;
		this.empSal = empSal;
		this.empGender = empGender;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPhNum() {
		return empPhNum;
	}

	public void setEmpPhNum(String empPhNum) {
		this.empPhNum = empPhNum;
	}

	public int getEmpSal() {
		return empSal;
	}

	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empPhNum=" + empPhNum
				+ ", empSal=" + empSal + ", empGender=" + empGender + "]";
	}

}
