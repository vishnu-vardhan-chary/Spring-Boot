package com.nit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.nit.constant.Constant.*;

import com.nit.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EmployeeRowMapper rowMapper;
	
	@Override
	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public void saveEmployee(Employee emp) {
		log.debug("Name: {}, Address:{}, Salary: {}", emp.getName(),emp.getAddress(), emp.getSalary());
		jdbcTemplate.update(INSERT,emp.getName(),emp.getAddress(),emp.getSalary());
		log.info("Employee is saveed successfully.");
	}

	@Override
	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public void updateEmployee(Employee emp) {
		log.debug("Id: {}, Name: {}, Address:{}, Salary: {}",emp.getId(), emp.getName(),emp.getAddress(), emp.getSalary());
		jdbcTemplate.update(UPDATE,emp.getName(),emp.getAddress(),emp.getSalary(),emp.getId());
		log.info("Employee is updated successfully.");
	}

	@Override
	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public void deleteEmployee(Long id) {
		jdbcTemplate.update(DELETE,id);
		log.info("Employee is deleted successfully.");
	}

	@Override
	public Employee getEmployee(Long id) {
		log.info("Enter into getEmployee() successfully.");
		List<Employee> emps = jdbcTemplate.query(GET_ONE, rowMapper, id);
		if (!emps.isEmpty()) return emps.get(0);
		return null;	
	}

	@Override
	public List<Employee> getAllEmployees() {
		log.info("Enter into getAllEmployees() successfully.");
		return jdbcTemplate.query(GET_All, rowMapper);
	}
	

}
