package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nit.entity.Employee;
import com.nit.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;
import static com.nit.constant.Constant.GET_ALL_EMPLOYEES;
import static com.nit.constant.Constant.ADD_EMPLOYEE;
import static com.nit.constant.Constant.EMP_ID;
import static com.nit.constant.Constant.ADD_EMPLOYEE_URL;
import static com.nit.constant.Constant.SHOW_EMPLOYEES;
import static com.nit.constant.Constant.SAVE_EMPLOYEE_URL;
import static com.nit.constant.Constant.DELETE_EMPLOYEE_URL;
import static com.nit.constant.Constant.GET_EMPLOYEE_URL;
import static com.nit.constant.Constant.GET_ALL_EMPLOYEES_URL;
import static com.nit.constant.Constant.HOME;
import static com.nit.constant.Constant.HOME_URL;
import static com.nit.constant.Constant.SHOW_EMPLOYEE;
import static com.nit.constant.Constant.UPDATE_EMPLOYEE_URL;



@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(HOME_URL)
	public String home() {
		return HOME;
	}
	@RequestMapping(GET_ALL_EMPLOYEES_URL)
	public String getAllEmployees(Model model) {
		List<Employee> emps =  employeeService.getAllEmployees();
		model.addAttribute("emps", emps);
		return SHOW_EMPLOYEES;
	}
	
	
	@RequestMapping(GET_EMPLOYEE_URL)
	public String getEmployee(HttpServletRequest request, Model model) {
		String empId = request.getParameter(EMP_ID);
		Employee emp = employeeService.getEmployee(Long.valueOf(empId));
		model.addAttribute(emp);
		return SHOW_EMPLOYEE;
	}
	
	@RequestMapping(DELETE_EMPLOYEE_URL)
	public String deleteEmployee(HttpServletRequest request) {
		String empId = request.getParameter(EMP_ID);
		employeeService.deleteEmployee(Long.valueOf(empId));
		return GET_ALL_EMPLOYEES;
	}
	
	@RequestMapping(SAVE_EMPLOYEE_URL)
	public String saveEmployee(@ModelAttribute Employee emp) {
		employeeService.saveEmployee(emp);
		return GET_ALL_EMPLOYEES;
	}
	
	@RequestMapping(UPDATE_EMPLOYEE_URL)
	public String updateEmployee(@ModelAttribute Employee emp) {
		employeeService.updateEmployee(emp);
		return GET_ALL_EMPLOYEES;
	}
	
	@RequestMapping(ADD_EMPLOYEE_URL)
	public String addEmployee(Model model) {
		model.addAttribute(new Employee(null,"Ameerpet",null));
		return ADD_EMPLOYEE;
	}
}
