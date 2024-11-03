package com.nit.constant;

public class Constant {
	//Queries
	public static final String GET_ALL ="select * from employee";
	public static final String GET_ONE ="select * from employee where id=?";
	public static final String DELETE ="delete from employee where id=?";
	public static final String INSERT ="insert into employee(name,address,salary) values(?,?,?)" ;
	public static final String UPDATE ="update employee set name=?,address=?,salary=? where id=?" ;
	 
	//URLs
	public static final String ADD_EMPLOYEE_URL = "/addEmployee";
	public static final String SAVE_EMPLOYEE_URL ="/saveEmployee";
	public static final String DELETE_EMPLOYEE_URL ="/deleteEmployee";
	public static final String GET_ALL_EMPLOYEES_URL ="/getAllEmployees";
	public static final String HOME_URL ="/";
	public static final String GET_EMPLOYEE_URL ="/getEmployee";
	public static final String UPDATE_EMPLOYEE_URL="/updateEmployee";
	
	//Views
	public static final String GET_ALL_EMPLOYEES = "redirect:/getAllEmployees";
	public static final String ADD_EMPLOYEE = "add_employee";
	public static final String UPDATE_EMPLOYEE = "update_employee";
	public static final String EMP_ID = "emp_id";
	public static final String SHOW_EMPLOYEES = "show_employees";
	public static final String SHOW_EMPLOYEE = "show_employee";
	public static final String HOME ="home";
	
	
}
