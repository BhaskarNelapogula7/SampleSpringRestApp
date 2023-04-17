package com.app.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp_tab")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	
	@Column(name="emp_Name")
	private String empName;
	
	@Column(name="emp_desig")
	private String empDesig;
	
	@Column(name="emp_sal")
	private int empSal;
	
	@Column(name="emp_status")
	private String empStatus;
	
	@Column(name="emp_age")
	private int empAge;
	
	@Column(name="emp_gender")
	private String empGender;
	

	public Employee(Integer empId) {
		super();
		this.empId = empId;
	}


	public Employee(Integer empId, String empName, String empDesig, int empSal, String empStatus, int empAge,
			String empGender) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDesig = empDesig;
		this.empSal = empSal;
		this.empStatus = empStatus;
		this.empAge = empAge;
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


	public String getEmpDesig() {
		return empDesig;
	}


	public void setEmpDesig(String empDesig) {
		this.empDesig = empDesig;
	}


	public int getEmpSal() {
		return empSal;
	}


	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}


	public String getEmpStatus() {
		return empStatus;
	}


	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}


	public int getEmpAge() {
		return empAge;
	}


	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}


	public String getEmpGender() {
		return empGender;
	}


	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDesig=" + empDesig + ", empSal=" + empSal
				+ ", empStatus=" + empStatus + ", empAge=" + empAge + ", empGender=" + empGender + "]";
	}
		
}
