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
    private EmployeeRepo empRepo;

    public Employee saveEmployee(Employee employee) {
        return empRepo.save(employee);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return empRepo.findById(id).get();
    }

    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    @Override
    public void deleteEmployee(Integer id) {
        empRepo.deleteById(id);
    }

    public Employee updateEmployee(Employee employee) {
        return empRepo.save(employee);
    }



}
