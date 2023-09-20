package com.app.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Employee;
import com.app.repository.EmployeeRepo;
import com.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	//add the service layer methods to handle the business logic
	@Autowired
	private EmployeeRepo employeeRepo;
	@Override
	public Employee saveEmployee(Employee empObj) {
		return employeeRepo.save(empObj);
	}
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}
	@Override
	public Employee getEmployeeById(Integer id) {
		return employeeRepo.findById(id).get();
	}
	@Override
	public void deleteEmployee(Integer id) {
		employeeRepo.deleteById(id);
	}
	@Override
	public Employee updateEmployee(Employee empObj) {
		return employeeRepo.save(empObj);
	}
	@Override
	public Employee patchEmployee(Employee empObj) {
		return employeeRepo.save(empObj);
	}

}
