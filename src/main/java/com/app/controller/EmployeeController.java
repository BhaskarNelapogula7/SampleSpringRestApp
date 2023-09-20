package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.Exception.EmployeeNotFoundException;
import com.app.dto.EmployeeDto;
import com.app.entity.Employee;
import com.app.service.serviceImpl.EmployeeServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl empService;

	@Autowired
	private ModelMapper modelMapper;

	@Operation(summary="store employee data into db")
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDto empDto) throws EmployeeNotFoundException {
		ResponseEntity<Employee> resp = null;
		try {
			Employee emp = modelMapper.map(empDto, Employee.class);
			Employee saveEmployee = empService.saveEmployee(emp);
			resp = new ResponseEntity<Employee>(saveEmployee, HttpStatus.OK);
		} catch (Exception e) {
			throw new EmployeeNotFoundException("primary key vailation please check once");

		}
		return (ResponseEntity<Employee>) resp;
	}
	@Operation(summary="get employee data from db by id")
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Integer id) throws EmployeeNotFoundException {

		Employee employee = empService.getEmployeeById(id);

		EmployeeDto empDto = modelMapper.map(employee, EmployeeDto.class);
		if (employee != null) {
			return new ResponseEntity<EmployeeDto>(empDto, HttpStatus.OK);
		} else {
			throw new EmployeeNotFoundException("primary key violation please check once");
		}
	}
	@Operation(summary="get all employee data from db")
	@GetMapping
	public ResponseEntity<?> getAllEmployees() {
		List<Employee> allEmployees = empService.getAllEmployees();
		List<EmployeeDto> employeeDto = new ArrayList<>();
		EmployeeDto empDto = modelMapper.map(allEmployees, EmployeeDto.class);
		if (!allEmployees.isEmpty()) {
			for (Employee emp : allEmployees) {
				employeeDto.add(modelMapper.map(emp, EmployeeDto.class));
			}
		}
		return new ResponseEntity<>(employeeDto, HttpStatus.OK);
	}
	@Operation(summary="delete employee data by id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer id) throws EmployeeNotFoundException {
		ResponseEntity<?> resp = null;
		try {
			empService.deleteEmployee(id);
			resp = new ResponseEntity<>("Deleted employee id=" +   id + " successfully", HttpStatus.OK);
		} catch (Exception e) {
			throw new EmployeeNotFoundException("Employee id not found in database");
		}
		return resp;
	}
	@Operation(summary="update data by id")
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable Integer id,@RequestBody EmployeeDto employeeDto) throws EmployeeNotFoundException{

		Employee emp = empService.getEmployeeById(id);
		if (emp != null) {
			emp.setEmpName(employeeDto.getEmpName());
			emp.setEmpEmail(employeeDto.getEmpEmail());
			emp.setEmpPhNum(employeeDto.getEmpPhNum());
			emp.setEmpSal(employeeDto.getEmpSal());
			emp.setEmpGender(employeeDto.getEmpGender());
			empService.updateEmployee(emp);
			return new ResponseEntity<>(emp,HttpStatus.OK);
		}
		else {
			throw new EmployeeNotFoundException("Employee id not found in database");
		}
	}
	@Operation(summary="patch data by id")
	@PatchMapping(value = "/{id}")
	public ResponseEntity<?> patchEmployee(@PathVariable Integer id,@RequestBody EmployeeDto employeeDto) throws EmployeeNotFoundException{

		Employee emp = empService.getEmployeeById(id);
		if (emp != null) {
			if(employeeDto.getEmpName()!=null)
			emp.setEmpName(employeeDto.getEmpName());
			if (employeeDto.getEmpEmail()!=null)
			emp.setEmpEmail(employeeDto.getEmpEmail());
			if(employeeDto.getEmpPhNum()!=null)
			emp.setEmpPhNum(employeeDto.getEmpPhNum());
			if(employeeDto.getEmpSal()!=0)
			emp.setEmpSal(employeeDto.getEmpSal());
			if(employeeDto.getEmpGender()!=null)
			emp.setEmpGender(employeeDto.getEmpGender());
			empService.updateEmployee(emp);
			return new ResponseEntity<>(emp,HttpStatus.OK);
		}
		else {
			throw new EmployeeNotFoundException("Employee id not found in database");
		}
	}




}