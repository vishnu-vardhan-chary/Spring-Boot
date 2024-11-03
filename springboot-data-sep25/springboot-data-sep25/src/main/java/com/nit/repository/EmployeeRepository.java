package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nit.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	List<Employee> findByName(String name);
	List<Employee> findByNameAndSalary(String name, Double salary);
	List<Employee> findByNameOrSalary(String name, Double salary);
	List<Employee> findBySalaryBetween(Double start, Double end);
	List<Employee> findBySalaryLessThan(Double end);
	List<Employee> findByNameLike(String name);
	List<Employee> findByNameStartingWith(String name);
	
	@Query("from Employee order by name desc")
	List<Employee> getAllEmployeesInOrder();
	
	@Query("from Employee where address like :value")
	List<Employee> getAllEmployeesAddress(@Param("value") String address);
	
	@Query("from Employee where salary <= :salary")
	List<Employee> getAllSalaiedEmployees(@Param("salary") Double salary);
	
	@Query("select max(salary) from Employee")
	Double getMaxSalary();
	
	@Query(value = "SELECT * FROM employee order by name desc", nativeQuery = true)
	List<Employee> getAllEmployeesWithNativeSQL();
	
	@Query(value="SELECT MAX(SALARY) FROM Employee WHERE SALARY < (SELECT MAX(SALARY) FROM Employee)",nativeQuery = true)
	Double getSecondMaxSalary();
}
