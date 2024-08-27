package com.org.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.app.entity.Employee;
import com.org.app.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmpController {
	
	@Autowired
	EmployeeService empService;

	@GetMapping()
	public String getEmployees(Model theModel) {
		
		List<Employee> employees = empService.findAllEmployees();
		
		theModel.addAttribute("employees", employees);
		
		return "employee/employees-list";
	}
	
	@GetMapping("/form")
	public String showForm(Model theModel) {
		Employee employee = new Employee();
		theModel.addAttribute("employee", employee);
		return "employee/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee myEmployee) {
		
		empService.saveEmployee(myEmployee);
		
		return "redirect:/employees";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
									Model theModel) {

		// get the employee from the service
		Employee employee = empService.findEmployeeById(theId);

		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("employee", employee);

		// send over to our form
		return "employee/employee-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {

		// delete the employee
		empService.deleteEmployeeById(theId);

		// redirect to /employees/list
		return "redirect:/employees";

	}
}
