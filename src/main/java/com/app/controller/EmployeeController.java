package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.Exception.EmployeeNotFoundException;
import com.app.dto.EmployeeDto;
import com.app.entity.Employee;
import com.app.service.serviceImpl.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl empService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDto empDto) throws EmployeeNotFoundException {
		ResponseEntity<Employee> resp = null;
		try {
			// convert DTO to an entity
			// modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

			
			Employee emp = modelMapper.map(empDto, Employee.class);
			Employee saveEmployee = empService.saveEmployee(emp);
			resp = new ResponseEntity<Employee>(saveEmployee, HttpStatus.OK);
		} catch (Exception e) {
			throw new EmployeeNotFoundException("primary key vailation please check once");

		}
		return (ResponseEntity<Employee>) resp;
	}

	/*
	 * @GetMapping("/getid/{id}") public ResponseEntity<Employee>
	 * getEmployeeById(@PathVariable Integer id) throws EmployeeNotFoundException {
	 * 
	 * ResponseEntity<Employee> resp = null; try { Optional<Employee> emp =
	 * empService.getEmployeeById(id); // convert entity to DTO //
	 * modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	 * EmployeeDto empDto = modelMapper.map(emp, EmployeeDto.class);
	 * 
	 * System.out.println("the transefed object"+empDto); if (empDto != null) {
	 * 
	 * resp = new ResponseEntity<Employee>(HttpStatus.OK); } else resp = new
	 * ResponseEntity<>(HttpStatus.BAD_REQUEST);
	 * 
	 * } catch (Exception ex) {
	 * 
	 * throw new
	 * EmployeeNotFoundException("Employee Deatails not found this id in database");
	 * } return resp; }
	 */
	
	@GetMapping("/getid/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Integer id) throws EmployeeNotFoundException {

		Employee employee = empService.getEmployeeById(id);

		EmployeeDto empDto = modelMapper.map(employee, EmployeeDto.class);

		if (employee != null) {

			return new ResponseEntity<EmployeeDto>(empDto, HttpStatus.OK);

		} else {

			throw new EmployeeNotFoundException("primary key vailation please check once");
		}
	}

	@GetMapping(value = "/getAll")
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
	/*
	 * @GetMapping(value = "/getAll") public ResponseEntity<?> getAllEmployees()
	 * throws EmployeeNotFoundException { ResponseEntity<?> resp = null; try {
	 * List<Employee> listofEmployees = empService.getAllEmployees();
	 * List<EmployeeDto> listofUserDto = new ArrayList<EmployeeDto>(); if
	 * (!listofEmployees.isEmpty()) { for (Employee emp : listofEmployees) { //
	 * convert entity to DTO listofUserDto.add(modelMapper.map(emp,
	 * EmployeeDto.class)); } if (listofUserDto != null && !listofUserDto.isEmpty())
	 * { resp = new ResponseEntity<List<EmployeeDto>>(listofUserDto, HttpStatus.OK);
	 * } else resp = new ResponseEntity<>("No data found", HttpStatus.BAD_REQUEST);
	 * } } catch (Exception e) { throw new
	 * EmployeeNotFoundException("Employee Details not found in database"); } return
	 * resp; }
	 */

	@DeleteMapping("/delete/{id}")
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

	/*
	 * @PutMapping(value = "/update/{id}") public ResponseEntity<?>
	 * updateEmployee(@PathVariable Integer id, @RequestBody Employee empDetails)
	 * throws EmployeeNotFoundException {
	 * 
	 * ResponseEntity<?> resp = null; try { Employee emp =
	 * empService.getEmployeeById(id); if (emp != null) {
	 * emp.setEmpName(empDetails.getEmpName());
	 * emp.setEmpEmail(empDetails.getEmpEmail());
	 * emp.setEmpPhNum(empDetails.getEmpPhNum());
	 * emp.setEmpSal(empDetails.getEmpSal());
	 * emp.setEmpGender(empDetails.getEmpGender()); empService.updateEmployee(emp);
	 * resp = new ResponseEntity<>("Employee details updated successfully",
	 * HttpStatus.OK); } else { resp = new
	 * ResponseEntity<>("Employee details not found with" + id + " in database",
	 * HttpStatus.BAD_REQUEST); } } catch (Exception e) { throw new
	 * EmployeeNotFoundException("Details are not availble with in databse"); }
	 * return resp; }
	 */
	
	@PutMapping(value = "/update/{id}")
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
}