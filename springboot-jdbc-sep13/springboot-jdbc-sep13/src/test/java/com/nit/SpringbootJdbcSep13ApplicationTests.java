package com.nit;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nit.dao.EmployeeDao;
import com.nit.model.Employee;

@SpringBootTest
class SpringbootJdbcSep13ApplicationTests {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Test
	void testSaveEmployee() {
		Employee emp = new Employee("Arun", "Miyapur", 20000D);
		employeeDao.saveEmployee(emp);
	}
	@Test
	void testUpdateEmployee() {
		Employee emp = employeeDao.getEmployee(24L);
		emp.setName("ABCDEF");
		employeeDao.updateEmployee(emp);
		emp = employeeDao.getEmployee(24L);
		Assertions.assertEquals("ABCDEF", emp.getName());
	}
	
	@Test
	void testDeleteEmployee() {
		employeeDao.deleteEmployee(1L);
		Employee emp = employeeDao.getEmployee(1L);
		Assertions.assertNull(emp);
	}
	@Test
	void testGetEmployee() {
		Employee emp = employeeDao.getEmployee(2L);
		Assertions.assertNotNull(emp);
		Assertions.assertTrue(emp.getId() > 0);
	}
	@Test
	void testGetAllEmployees() {
		List<Employee> emps = employeeDao.getAllEmployees();
		Assertions.assertTrue(emps.size() > 0);
	}

}
