package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nit.entity.Employee;
import com.nit.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value = {"/","/home"})
	public String home(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "home";
	}
	
	@PostMapping("/searchByName")
	public String searchByName(HttpServletRequest request, Model model) {
		String name = request.getParameter("emp_name");
		model.addAttribute("employees", employeeService.searchEmployeeByName(name));
		return "home";
	}
	
	@PostMapping("/searchBySalary")
	public String searchBySalary(HttpServletRequest request, Model model) {
		String salary = request.getParameter("emp_salary");
		if (salary.length() == 0) return "redirect:/home";
		model.addAttribute("employees", employeeService.searchEmployeeBySalary(Double.valueOf(salary)));
		return "home";
	}
	
	@PostMapping("/searchByAddress")
	public String searchByAddress(HttpServletRequest request, Model model) {
		String address = request.getParameter("emp_address");
		model.addAttribute("employees", employeeService.searchEmployeeByAddress(address));
		return "home";
	}
	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
		model.addAttribute(new Employee());
		return "add_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@Validated Employee employee, BindingResult result) {
		if (result.hasErrors())
			return "add_employee";
		employeeService.saveEmployee(employee);
		return "redirect:/home";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/home";
	}
	
	@GetMapping("/editEmployee/{id}")
	public String editEmployee(@PathVariable("id") Long id, Model model) {
		Employee emp = employeeService.getEmployee(id);
		model.addAttribute(emp);
		return "update_employee";
	}
	
	@PostMapping("/updateEmployee")
	public String updateEmployee(@ModelAttribute Employee employee) {
		employeeService.updateEmployee(employee);
		return "redirect:/home";
	}
}
