//package com.org.app.controller;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.org.app.entity.Employee;
//import com.org.app.exception.EmployeeException;
//import com.org.app.service.EmployeeService;
//import com.org.app.utitlity.ResponseBody;
//
//@RestController
//@RequestMapping("/api")
//public class EmployeeController {
//
//	@Autowired
//	EmployeeService empService;
//
//	// Create employee
//	@PostMapping("/employees")
//	public ResponseEntity<ResponseBody> addStudent(@RequestBody Employee emp) {
//		
//		Employee savedEmployee = empService.saveEmployee(emp);
//
//		ResponseBody response = new ResponseBody();
//		response.setMessage("Student added succesfully with id "+savedEmployee.getEmpId());
//		response.setStatusCode(HttpStatus.CREATED.value());
//		response.setTimeStamp(LocalDateTime.now());
//		return new ResponseEntity<ResponseBody>(response, HttpStatus.CREATED);
//	}
//
//	// Retrieve Employee by id
//	@GetMapping("/employees/{id}")
//	public Employee getStudentById(@PathVariable Integer id) {
//		return empService.findEmployeeById(id);
//	}
//
//	// Retrieve all Employee
//	@GetMapping("/employees")
//	public List<Employee> getAllStudents() {
//		List<Employee> employees = empService.findAllEmployees();
//		if(employees.size() <= 0) {
//			throw new EmployeeException("No employees are available in database. Kindly add students.", HttpStatus.BAD_REQUEST);
//		}
//		return employees;
//	}
//
//	// Update Employee
//	@PutMapping("/employees")
//	public Employee updateStudent(@RequestBody Employee emp) {
//		Employee updatedEmp = empService.saveEmployee(emp);
//		ResponseBody response = new ResponseBody();
//		response.setMessage("Student updated succesfully with id "+updatedEmp.getEmpId());
//		response.setStatusCode(HttpStatus.OK.value());
//		response.setTimeStamp(LocalDateTime.now());
//		
//		return updatedEmp;
//	}
//
//	// Delete student by id
//	@DeleteMapping("/employees/{id}")
//	public ResponseEntity<ResponseBody> deleteStudentById(@PathVariable Integer id) {
//		Employee emp = empService.findEmployeeById(id);
//		ResponseBody response = new ResponseBody();
//		response.setMessage("Student deleted succesfully with id "+emp.getEmpId());
//		response.setStatusCode(HttpStatus.OK.value());
//		response.setTimeStamp(LocalDateTime.now());
//		
//		empService.deleteEmployeeById(id);
//
//		return new ResponseEntity<ResponseBody>(response, HttpStatus.OK);
//	}
//
//}
