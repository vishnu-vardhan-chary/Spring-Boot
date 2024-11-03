package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Employee;
import com.nit.repo.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable("id") Long id){
		return employeeRepository.findById(id).get();
	}
	
	@GetMapping("/getEmployeeByName/{name}")
	public List<Employee> getEmployeeByName(@PathVariable("name") String name){
		return employeeRepository.findByName(name);
	}
	
	@GetMapping("/getEmployeeByNameAndAddress/{name}/{address}")
	public List<Employee> getEmployeeByNameAndAddress(@PathVariable("name") String name, @PathVariable("address") String address){
		return employeeRepository.findByNameAndAddress(name,address);
	}
	
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee){
		return employeeRepository.save(employee);
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateeEmployee(@RequestBody Employee employee){
		return employeeRepository.save(employee);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable Long id){
		employeeRepository.deleteById(id);
		log.info("Employee record is removed successfully...");
	}
	
	@DeleteMapping("/deleteEmployee")
	public void deleteEmployeeUsingRequestParam(@RequestParam("id") Long id){
		employeeRepository.deleteById(id);
		log.info("Employee record is removed by using @RequestParam successfully...");
	}
}
