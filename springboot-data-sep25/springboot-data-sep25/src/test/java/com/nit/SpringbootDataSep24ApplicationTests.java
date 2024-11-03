package com.nit;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nit.entity.Employee;
import com.nit.repository.EmployeeRepository;

@SpringBootTest
class SpringbootDataSep24ApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	//@Test
	void testGetAllData() {
		List<Employee> emps = employeeRepository.findAll();
		emps.forEach(emp -> System.out.println(emp));
		Assertions.assertEquals(8, emps.size());
	}
	
	@Test
	void testGetData() {
		Employee emp = null;
		Optional<Employee> optEmp = employeeRepository.findById(40L);
		if (optEmp.isPresent()) {
			emp = optEmp.get();
			System.out.println(emp);
		}
		Assertions.assertNotNull(emp);
		Assertions.assertEquals(40, emp.getId());
	}

}
