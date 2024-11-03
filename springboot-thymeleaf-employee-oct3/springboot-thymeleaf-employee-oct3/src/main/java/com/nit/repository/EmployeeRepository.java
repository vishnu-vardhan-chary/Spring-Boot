package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	List<Employee> findByNameLike(String name);
	List<Employee> findByAddressLike(String address);
	List<Employee> findBySalaryLessThan(Double salary);
}
