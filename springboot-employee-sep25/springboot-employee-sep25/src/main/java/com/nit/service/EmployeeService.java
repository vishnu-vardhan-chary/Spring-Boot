package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nit.entity.Employee;
import com.nit.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public Employee getEmployee(Long id){
		return employeeRepository.findById(id).get();
	}
	
	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public void deleteEmployee(Long id){
		employeeRepository.deleteById(id);
		log.info("Employee is successfully deleted.");
	}

	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public void saveEmployee(Employee emp) {
		employeeRepository.save(emp);
		log.info("Employee is successfully saved.");	
	}
	
	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public void updateEmployee(Employee emp) {
		employeeRepository.save(emp);
		log.info("Employee is successfully updated.");	
	}
}
