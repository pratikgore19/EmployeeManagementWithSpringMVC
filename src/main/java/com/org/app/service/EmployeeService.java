package com.org.app.service;

import java.util.List;

import com.org.app.entity.Employee;


public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	Employee findEmployeeById(Integer id);
	List<Employee> findAllEmployees();
	void deleteEmployeeById(Integer id);
}
