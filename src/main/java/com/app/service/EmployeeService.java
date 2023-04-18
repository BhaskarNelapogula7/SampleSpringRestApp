package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee empObj);

	public Employee getEmployeeById(Integer id);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(Integer id);

	public Employee updateEmployee( Employee empObj);

	// public EmployeeDto converEntityToDto(Employee empObj);

}
