package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.app.SampleSpringRestAppApplication;

public interface EmployeeRepo extends JpaRepository<SampleSpringRestAppApplication, Integer>, CrudRepository<SampleSpringRestAppApplication, Integer>{
	

}
