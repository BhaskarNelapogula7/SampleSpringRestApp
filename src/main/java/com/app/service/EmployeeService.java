package com.app.service;

import java.util.List;

import com.app.Entity.Employee;

public interface EmployeeService {

	public Integer saveEmployee(Employee e);

	public void updateEmployee(Employee e);

	public Employee getEmployeeById(Integer id);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(Integer id);

}
