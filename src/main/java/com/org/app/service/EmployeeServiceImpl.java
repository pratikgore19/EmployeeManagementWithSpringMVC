package com.org.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.org.app.entity.Employee;
import com.org.app.exception.EmployeeException;
import com.org.app.repository.EmployeeRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return empRepo.save(employee);
	}

	@Override
	public Employee findEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		Employee emp = empRepo.findById(id).orElseThrow(()->new EmployeeException("No employee with id "+id+" found", HttpStatus.NOT_FOUND));
		return emp;
	}

	@Override
	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		empRepo.deleteById(id);
	}

}
