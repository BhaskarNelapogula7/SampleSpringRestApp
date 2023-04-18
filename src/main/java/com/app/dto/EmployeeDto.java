package com.app.dto;

public class EmployeeDto {

	private Integer empId;
	private String empName;
	private String empEmail;
	private String empPhNum;
	private int empSal;
	private String empGender;
	
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
		return "EmployeeDto [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empPhNum="
				+ empPhNum + ", empSal=" + empSal + ", empGender=" + empGender + "]";
	}
	
	
}
