package com.nit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nit.entity.Employee;
import com.nit.repository.EmployeeRepository;

@SpringBootApplication
public class SpringbootDataSep24Application implements CommandLineRunner{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataSep24Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Employee emp = new Employee("Ashok1", "BHEL", 25000D);
		emp = employeeRepository.save(emp);
		System.out.println(emp);
		*/
		//employeeRepository.deleteById(41L);
		
		/*
		Employee emp = employeeRepository.findById(44L).get();
		emp.setName("Raaama");
		emp = employeeRepository.save(emp);
		System.out.println(emp);
		*/
		/*
		List<Employee> emps = employeeRepository.findByName("Suresh");
		emps.forEach(emp ->System.err.println(emp));
		*/
		/*
		List<Employee> emps = employeeRepository.findByNameAndSalary("Suresh",50000D);
		emps.forEach(emp ->System.err.println(emp));
		
		List<Employee> emps = employeeRepository.findByNameOrSalary("Suresh",12000D);
		emps.forEach(emp ->System.err.println(emp));
		
		List<Employee> emps = employeeRepository.findBySalaryBetween(5000D,10000D);
		emps.forEach(emp ->System.err.println(emp));
		
		List<Employee> emps = employeeRepository.findBySalaryLessThan(15000D);
		emps.forEach(emp ->System.err.println(emp));
		
		List<Employee> emps = employeeRepository.findByNameLike("k%");
		emps.forEach(emp ->System.err.println(emp));
		
		List<Employee> emps = employeeRepository.findByNameStartingWith("S");
		emps.forEach(emp ->System.err.println(emp));
		
		List<Employee> emps = employeeRepository.findAll();
		emps.forEach(emp ->System.err.println(emp));
		
		
		List<Employee> emps = employeeRepository.getAllEmployeesInOrder();
		emps.forEach(emp ->System.err.println(emp));
		
		List<Employee> emps = employeeRepository.getAllEmployeesAddress("A%");
		emps.forEach(emp ->System.err.println(emp));
		
		List<Employee> emps = employeeRepository.getAllSalaiedEmployees(10000D);
		emps.forEach(emp ->System.err.println(emp));
		
		System.out.println("Max Salary is : "+employeeRepository.getMaxSalary());
		
		List<Employee> emps = employeeRepository.getAllEmployeesWithNativeSQL();
		emps.forEach(emp ->System.err.println(emp));
		*/
		System.out.println("Second Max Salary is : "+employeeRepository.getSecondMaxSalary());
		
	}

}
